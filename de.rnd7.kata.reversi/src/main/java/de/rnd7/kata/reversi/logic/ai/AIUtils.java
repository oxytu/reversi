/**
 * Copyright 2016 Philipp Arndt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.rnd7.kata.reversi.logic.ai;

import java.util.ArrayList;
import java.util.List;

import de.rnd7.kata.reversi.logic.GameLogic;
import de.rnd7.kata.reversi.model.Cell;
import de.rnd7.kata.reversi.model.CellState;
import de.rnd7.kata.reversi.model.GameField;

public class AIUtils {

	public static GameField cloneField(final GameField original) {
		final GameField gameField = new GameField();

		for (final Cell cell : original.getCells()) {
			gameField.getCell(cell.getCoordinate()).setState(cell.getState());
		}

		return gameField;
	}

	public static List<Cell> getPossibleMoves(final GameField field, final CellState player) {
		final GameField possibleMoves = cloneField(field);

		final List<Cell> possibleCells = new ArrayList<Cell>();
		final GameLogic gameLogic = new GameLogic(field);
		for (final Cell cell : field.getCells()) {
			if (gameLogic.isValidMove(player, cell)) {
				possibleMoves.getCell(cell.getCoordinate()).setState(CellState.ALLOWED);
				possibleCells.add(cell);
			}
		}

		return possibleCells;

	}
}
