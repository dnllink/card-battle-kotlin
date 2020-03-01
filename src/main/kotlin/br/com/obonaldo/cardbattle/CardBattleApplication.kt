package br.com.obonaldo.cardbattle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CardBattleApplication

fun main(args: Array<String>) {
	runApplication<CardBattleApplication>(*args)
}
