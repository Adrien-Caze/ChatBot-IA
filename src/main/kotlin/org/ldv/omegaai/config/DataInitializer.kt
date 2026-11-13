package org.ldv.omegaai.config

import org.ldv.omegaai.model.dao.FournisseurIADAO
import org.ldv.omegaai.model.dao.ModeleIADAO
import org.ldv.omegaai.model.entity.ModeleIA
import org.ldv.omegaai.model.entity.FournisseurIA
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DataInitializer(
    private val fourniseurIADAO: FournisseurIADAO,
    private val modeleIADAO: ModeleIADAO
) {

    @Bean
    fun initData() = CommandLineRunner {

        // Vérifier si le fournisseur Mistral existe déjà
        val mistral = fourniseurIADAO.findAll()
            .firstOrNull { it.nom == "Mistral" }
            ?: fourniseurIADAO.save(
                FournisseurIA(
                    nom = "Mistral",
                    cheminLogo = "/images/mistral.png",
                    description = "Fournisseur français de modèles d'intelligence artificielle."
                )
            )
        val gemini = fourniseurIADAO.findAll()
            .firstOrNull { it.nom == "Gemini" }
            ?: fourniseurIADAO.save(
                FournisseurIA(
                    nom = "Gemini",
                    cheminLogo = "/images/gemini.png",
                    description = "Modèles d'intelligence artificielle de Google."
                )
            )

        // Modèles à initialiser
        val modeles = listOf(
            ModeleIA(
                nom = "gemini-3.8-flash",
                urlAPI = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.8-flash:generateContent",
                description = "Modèle rapide et polyvalent.",
                cheminLogo = "/images/gemini.png",
                fourniseur = gemini
            ),

            ModeleIA(
                nom = "gemini-3.5-flash-lite",
                urlAPI = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash-lite:generateContent",
                description = "Modèle rapide pour les tâches simples.",
                cheminLogo = "/images/gemini.png",
                fourniseur = gemini
            ),
            ModeleIA(
                nom = "mistral-small-latest",
                urlAPI = "https://api.mistral.ai/v1/chat/completions",
                description = "Modèle léger pour les conversations et les tâches courantes.",
                cheminLogo = "/images/mistral.png",
                fourniseur = mistral
            ),

            ModeleIA(
                nom = "mistral-medium-latest",
                urlAPI = "https://api.mistral.ai/v1/chat/completions",
                description = "Modèle plus avancé pour les tâches complexes.",
                cheminLogo = "/images/mistral.png",
                fourniseur = mistral
            )
        )

        // Éviter de recréer les modèles à chaque démarrage
        for (modele in modeles) {
            val existe = modeleIADAO.findAll()
                .any { it.nom == modele.nom }

            if (!existe) {
                modeleIADAO.save(modele)
            }
        }
    }
}
