package br.com.obonaldo.cardbattle.domain

class Deck {

  private val list: MutableList<Int> = listOf(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8).shuffled().toMutableList()

  private fun takeCard(): Int? = list.removeAt(0)

  fun takeCards(quantity: Int): MutableList<Int> {
    val cards: MutableList<Int> = mutableListOf<Int>()
    for (i in 0 until quantity) {
      val card = takeCard()
      if (card != null)
        cards.add(card)
    }
    return cards
  }
}
