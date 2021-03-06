package jp.ac.uryukyu.ie.e215719;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created 2021/11/10.
 */
public class Enemy {
    private String name;
    /**
    * nameのgetterメソッド。
    * nameを取得する。
    * @param name 取得対象
    */
    public String getName() {
        return this.name;
    }
    private int hitPoint;
    private int attack;
    /**
    * attackのsetterメソッド。
    * 攻撃力を設定する。
    * @param attack 設定対象
    */
    public void setAttack(int attack) {
        if (attack < 0) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }
    private boolean dead;
    /**
    * deadのgetterメソッド。
    * 生死状態を取得する。
    * @param dead 取得対象
    */
    public boolean getDead() {
        return this.dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * 自身が死亡しているとき攻撃しない。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if(!dead) {
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
        hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}