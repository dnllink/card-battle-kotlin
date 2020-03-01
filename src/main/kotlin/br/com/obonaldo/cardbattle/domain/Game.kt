package br.com.obonaldo.cardbattle.domain

data class Game(
	val player1: Player,
	val player2: Player,
	val turns: List<Turn>)
