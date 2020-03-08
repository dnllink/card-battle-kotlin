package br.com.obonaldo.cardbattle

import br.com.obonaldo.cardbattle.domain.Game
import br.com.obonaldo.cardbattle.domain.Player

class CardBattleConsoleApplication

fun main(args: Array<String>) {
  val game = Game(
      Player("daniel"),
      Player("tati"))

  game.run()
}
