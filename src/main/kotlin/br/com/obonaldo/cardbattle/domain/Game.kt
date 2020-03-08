package br.com.obonaldo.cardbattle.domain

import org.slf4j.LoggerFactory
import kotlin.random.Random

data class Game(
    val player1: Player,
    val player2: Player) {

  private val logger = LoggerFactory.getLogger(Game::class.java)

  private var active = Random.Default.nextInt(3)
  private var turns = 1

  fun activePlayer(): Player =
      when (active) {
        1 -> player1
        else -> player2
      }

  fun inactivePlayer(): Player =
      when (active) {
        1 -> player2
        else -> player1
      }

  fun endTurn() {
    turns++
    active = if (active == 1) 2 else 1
  }

  fun startTurn() = activePlayer()
      .apply {
        increaseMaxMana()
        refillCurrentMana()
        moveCardToHand(1)
      }

  fun attack(damage: Int) {
    if (activePlayer().hasEnoughMana(damage)) {
      activePlayer().decreaseMana(damage)
      inactivePlayer().decreaseHealth(damage)
      activePlayer().removeCardFromHand(damage)
      logger.info("ataque causou $damage de dano")
    }
  }

  fun run() {
    while (player1.isAlive() && player2.isAlive()) {
      startTurn()
      logger.info("turno $turns")
      logger.info("jogador ${activePlayer().name}")
      logger.info(activePlayer().toString())
      activePlayer()
          .hand
          .filter { it <= activePlayer().currentMana }
          .max()
          ?.let { attack(it) }
      endTurn()
    }
    listOf(player1, player2)
        .first { it.isAlive() }
        .let {
          logger.info("${it.name} é o vencedor")
        }
  }
}
