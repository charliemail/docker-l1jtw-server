/**
 *                            License
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS  
 * CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE"). 
 * THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.  
 * ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR  
 * COPYRIGHT LAW IS PROHIBITED.
 * 
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND  
 * AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE EXTENT THIS LICENSE  
 * MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED 
 * HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 * 
 */
package l1j.server.server.model.map;

import l1j.server.server.types.Point;

/**
 * L1Map 保持地圖資訊，並提供對該資訊的各種介面。
 */
public abstract class L1Map {
	private static L1NullMap _nullMap = new L1NullMap();

	protected L1Map() {
	}

	/**
	 * 回傳此地圖的地圖ID。
	 * 
	 * @return 地圖ID
	 */
	public abstract int getId();

	// TODO JavaDoc
	public abstract int getX();

	public abstract int getY();

	public abstract int getWidth();

	public abstract int getHeight();

	/**
	 * 回傳指定座標的值。
	 * 
	 * 不建議使用。此方法為與既有程式碼相容而提供。
	 * L1Map 的使用者通常不需要知道地圖中儲存了哪些值，
	 * 也不應撰寫依賴於儲存值的程式碼。僅在除錯等特殊情況下可使用此方法。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 指定座標的值
	 */
	public abstract int getTile(int x, int y);

	/**
	 * 回傳指定座標的值（原始地圖）。
	 * 
	 * 不建議使用。此方法為與既有程式碼相容而提供。
	 * L1Map 的使用者通常不需要知道地圖中儲存了哪些值，
	 * 也不應撰寫依賴於儲存值的程式碼。僅在除錯等特殊情況下可使用此方法。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 指定座標的值
	 */
	public abstract int getOriginalTile(int x, int y);

	/**
	 * 判斷指定座標是否在地圖範圍內。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @return 在範圍內則回傳 true
	 */
	public abstract boolean isInMap(Point pt);

	/**
	 * 判斷指定座標是否在地圖範圍內。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 在範圍內則回傳 true
	 */
	public abstract boolean isInMap(int x, int y);

	/**
	 * 判斷指定座標是否可通行。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @return 可通行則回傳 true
	 */
	public abstract boolean isPassable(Point pt);

	/**
	 * 判斷指定座標是否可通行。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 可通行則回傳 true
	 */
	public abstract boolean isPassable(int x, int y);

	/**
	 * 判斷指定座標在 heading 方向是否可通行。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @return 可通行則回傳 true
	 */
	public abstract boolean isPassable(Point pt, int heading);

	/**
	 * 判斷指定座標在 heading 方向是否可通行。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 可通行則回傳 true
	 */
	public abstract boolean isPassable(int x, int y, int heading);

	/**
	 * 設定指定座標的可通行/不可通行。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @param isPassable
	 *            可通行則為 true
	 */
	public abstract void setPassable(Point pt, boolean isPassable);

	/**
	 * 設定指定座標的可通行/不可通行。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @param isPassable
	 *            可通行則為 true
	 */
	public abstract void setPassable(int x, int y, boolean isPassable);

	/**
	 * 判斷指定座標是否為安全區域（Safety Zone）。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @return 為安全區域則回傳 true
	 */
	public abstract boolean isSafetyZone(Point pt);

	/**
	 * 判斷指定座標是否為安全區域（Safety Zone）。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 為安全區域則回傳 true
	 */
	public abstract boolean isSafetyZone(int x, int y);

	/**
	 * 判斷指定座標是否為戰鬥區域（Combat Zone）。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @return 為戰鬥區域則回傳 true
	 */
	public abstract boolean isCombatZone(Point pt);

	/**
	 * 判斷指定座標是否為戰鬥區域（Combat Zone）。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 為戰鬥區域則回傳 true
	 */
	public abstract boolean isCombatZone(int x, int y);

	/**
	 * 判斷指定座標是否為一般區域（Normal Zone）。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @return 為一般區域則回傳 true
	 */
	public abstract boolean isNormalZone(Point pt);

	/**
	 * 判斷指定座標是否為一般區域（Normal Zone）。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 為一般區域則回傳 true
	 */
	public abstract boolean isNormalZone(int x, int y);

	/**
	 * 判斷指定座標是否允許箭矢或魔法穿透。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @return 允許穿透則回傳 true
	 */
	public abstract boolean isArrowPassable(Point pt);

	/**
	 * 判斷指定座標是否允許箭矢或魔法穿透。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 允許穿透則回傳 true
	 */
	public abstract boolean isArrowPassable(int x, int y);

	/**
	 * 判斷指定座標在 heading 方向是否允許箭矢或魔法穿透。
	 * 
	 * @param pt
	 *            保存座標的 Point 物件
	 * @param heading
	 *            方向
	 * @return 允許穿透則回傳 true
	 */
	public abstract boolean isArrowPassable(Point pt, int heading);

	/**
	 * 判斷指定座標在 heading 方向是否允許箭矢或魔法穿透。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @param heading
	 *            方向
	 * @return 允許穿透則回傳 true
	 */
	public abstract boolean isArrowPassable(int x, int y, int heading);

	/**
	 * 判斷此地圖是否為水中地圖。
	 * 
	 * @return 若為水中則回傳 true
	 */
	public abstract boolean isUnderwater();

	/**
	 * 判斷此地圖是否可加入書籤。
	 * 
	 * @return 可加入書籤則回傳 true
	 */
	public abstract boolean isMarkable();

	/**
	 * 判斷此地圖是否可進行隨機傳送。
	 * 
	 * @return 可進行隨機傳送則回傳 true
	 */
	public abstract boolean isTeleportable();

	/**
	 * 判斷此地圖是否允許超出地圖範圍的傳送（可逃離地圖）。
	 * 
	 * @return 允許則回傳 true
	 */
	public abstract boolean isEscapable();

	/**
	 * 判斷此地圖是否允許復活。
	 * 
	 * @return 允許復活則回傳 true
	 */
	public abstract boolean isUseResurrection();

	/**
	 * 判斷此地圖是否允許使用 Painwand。
	 * 
	 * @return 允許使用則回傳 true
	 */
	public abstract boolean isUsePainwand();

	/**
	 * 判斷此地圖是否有死亡懲罰（Death Penalty）。
	 * 
	 * @return 有則回傳 true
	 */
	public abstract boolean isEnabledDeathPenalty();

	/**
	 * 判斷此地圖是否可攜帶寵物/召喚獸。
	 * 
	 * @return 可攜帶則回傳 true
	 */
	public abstract boolean isTakePets();

	/**
	 * 判斷此地圖是否可召喚寵物/召喚獸。
	 * 
	 * @return 可召喚則回傳 true
	 */
	public abstract boolean isRecallPets();

	/**
	 * 判斷此地圖是否可使用道具。
	 * 
	 * @return 可使用則回傳 true
	 */
	public abstract boolean isUsableItem();

	/**
	 * 判斷此地圖是否可使用技能。
	 * 
	 * @return 可使用則回傳 true
	 */
	public abstract boolean isUsableSkill();

	/**
	 * 判斷指定座標是否為釣魚區域。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 為釣魚區域則回傳 true
	 */
    public abstract boolean isFishingZone(int x, int y);

	/**
	 * 判斷指定座標是否存在門（Door）。
	 * 
	 * @param x
	 *            座標的 X 值
	 * @param y
	 *            座標的 Y 值
	 * @return 若存在門則回傳 true
	 */
    public abstract boolean isExistDoor(int x, int y);

	public static L1Map newNull() {
		return _nullMap;
	}

	/**
	 * 回傳指定 pt 的格子（tile）文字表示。
	 */
	public abstract String toString(Point pt);

	/**
	 * 判斷此地圖是否為 null。
	 * 
	 * @return 若為 null 則回傳 true
	 */
	public boolean isNull() {
		return false;
	}
}

/**
 * 何もしないMap。
 */
class L1NullMap extends L1Map {
	public L1NullMap() {
	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public int getTile(int x, int y) {
		return 0;
	}

	@Override
	public int getOriginalTile(int x, int y) {
		return 0;
	}

	@Override
	public boolean isInMap(int x, int y) {
		return false;
	}

	@Override
	public boolean isInMap(Point pt) {
		return false;
	}

	@Override
	public boolean isPassable(int x, int y) {
		return false;
	}

	@Override
	public boolean isPassable(Point pt) {
		return false;
	}

	@Override
	public boolean isPassable(int x, int y, int heading) {
		return false;
	}

	@Override
	public boolean isPassable(Point pt, int heading) {
		return false;
	}

	@Override
	public void setPassable(int x, int y, boolean isPassable) {
	}

	@Override
	public void setPassable(Point pt, boolean isPassable) {
	}

	@Override
	public boolean isSafetyZone(int x, int y) {
		return false;
	}

	@Override
	public boolean isSafetyZone(Point pt) {
		return false;
	}

	@Override
	public boolean isCombatZone(int x, int y) {
		return false;
	}

	@Override
	public boolean isCombatZone(Point pt) {
		return false;
	}

	@Override
	public boolean isNormalZone(int x, int y) {
		return false;
	}

	@Override
	public boolean isNormalZone(Point pt) {
		return false;
	}

	@Override
	public boolean isArrowPassable(int x, int y) {
		return false;
	}

	@Override
	public boolean isArrowPassable(Point pt) {
		return false;
	}

	@Override
	public boolean isArrowPassable(int x, int y, int heading) {
		return false;
	}

	@Override
	public boolean isArrowPassable(Point pt, int heading) {
		return false;
	}

	@Override
	public boolean isUnderwater() {
		return false;
	}

	@Override
	public boolean isMarkable() {
		return false;
	}

	@Override
	public boolean isTeleportable() {
		return false;
	}

	@Override
	public boolean isEscapable() {
		return false;
	}

	@Override
	public boolean isUseResurrection() {
		return false;
	}

	@Override
	public boolean isUsePainwand() {
		return false;
	}

	@Override
	public boolean isEnabledDeathPenalty() {
		return false;
	}

	@Override
	public boolean isTakePets() {
		return false;
	}

	@Override
	public boolean isRecallPets() {
		return false;
	}

	@Override
	public boolean isUsableItem() {
		return false;
	}

	@Override
	public boolean isUsableSkill() {
		return false;
	}

	@Override
	public boolean isFishingZone(int x, int y) {
		return false;
	}

	@Override
	public boolean isExistDoor(int x, int y) {
		return false;
	}

	@Override
	public String toString(Point pt) {
		return "null";
	}

	@Override
	public boolean isNull() {
		return true;
	}
}
