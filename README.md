# 課題 11-1: カプセル化

### 課題の説明
以下の勇者クラスをカプセル化し、実行結果が実行例と同じになるようにmainメソッドを修正しなさい。

### 勇者クラス
```java
public class Hero
{
    String name = "工太";
    int hp=100;

    public void attack(Slime m) //戦う
    {
        System.out.println(this.name + "はスライム" + m.suffix + "に攻撃した！");
        System.out.println("敵に５ポイントのダメージをあたえた！");
        m.hp -= 5;
    }
}
```

### ProgB1.java
```java
public class ProgB1 {

    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "太郎";
        h.hp = 100;

        System.out.println("勇者" + h.name + " (HP:" + h.hp + ") が誕生した!");
    }

}
```

### 実行例
```
勇者太郎 (HP:100) が誕生した!
```
