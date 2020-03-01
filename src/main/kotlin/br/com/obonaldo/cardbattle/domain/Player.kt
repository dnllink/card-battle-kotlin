package br.com.obonaldo.cardbattle.domain

data class Player(
	val name: String) {

	var health: Int = 30
	var maxMana: Int = 0
	var currentMana: Int = 0
	val deck: Deck = Deck()
	val hand: MutableList<Int> = deck.takeCards(3)

	fun alive(): Boolean = health > 0

	fun increaseMaxMana() {
		if (maxMana < 10)
			maxMana = maxMana.inc()
	}

	fun refillCurrentMana() {
		currentMana = maxMana
	}

	fun decreaseMana(quantity: Int) {
		currentMana = currentMana.minus(quantity)
	}

	fun hasEnoughMana(quantity: Int): Boolean = currentMana >= quantity

	fun decreaseHealth(quantity: Int) {
		health = health.minus(quantity)
	}
}
