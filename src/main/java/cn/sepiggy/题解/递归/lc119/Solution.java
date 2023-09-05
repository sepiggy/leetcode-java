package cn.sepiggy.题解.递归.lc119;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * lc119. 杨辉三角 II
 * https://leetcode.cn/problems/pascals-triangle-ii/
 */
class Solution {
	/**
	 * 返回第rowIndex行
	 *
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {

		if (rowIndex == 0) {
			return Stream.of(1).collect(Collectors.toList());
		}

		if (rowIndex == 1) {
			return Stream.of(1, 1).collect(Collectors.toList());
		}

		List<Integer> lastRow = getRow(rowIndex - 1);

		List<Integer> curRow = new ArrayList<>();
		curRow.add(1);
		for (int i = 0; i < lastRow.size() - 1; i++) {
			curRow.add(lastRow.get(i) + lastRow.get(i + 1));
		}
		curRow.add(1);

		return curRow;
	}
}