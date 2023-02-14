package com.example.mappers

import com.example.models.PlayerByPersonaName
import com.example.models.PlayerByPersonaNameItem

class PlayerByPersonaNameMapper {

    fun toPlayerByPersonaName(playerByPersonaNameItemList: List<PlayerByPersonaNameItem>): List<PlayerByPersonaName> {
        return playerByPersonaNameItemList.map {
            PlayerByPersonaName(
                it.personaName,
                it.accountId
            )
        }
    }
}