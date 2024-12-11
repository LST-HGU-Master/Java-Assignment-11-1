import org.junit.jupiter.api.Test;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @version (2024Dec11) method名が見つからない例外発生でのエラーメッセージの修正
 * @version (20220608)
 */
public class HeroTest {

    @Test
    public void testPrivate() {
        try{
            // action
            Hero h = new Hero();
            Field name = h.getClass().getDeclaredField("name");
            Field hp = h.getClass().getDeclaredField("hp");

            assertEquals(Modifier.PRIVATE, name.getModifiers(),"Heroクラスのフィールドnameがprivate宣言されていません!");
            assertEquals(Modifier.PRIVATE, hp.getModifiers(),"hpがprivate宣言されていません!");
        } catch (NoSuchFieldException e) {
            fail("Heroクラスのフィールドとして name または hp が定義されていません!");
        }
    }

    @Test
    public void testSetName() {
        try{
            // action
            Hero h = new Hero();
            Method setName = h.getClass().getMethod("setName", String.class);
            //Method setHp = h.getClass().getMethod("setHp", int.class);
            setName.invoke(h, "二郎");
            //setHp.invoke(h, 90);

            Field name = h.getClass().getDeclaredField("name");
            //Field hp = h.getClass().getDeclaredField("hp");

            name.setAccessible(true);
            //hp.setAccessible(true);

            assertEquals("二郎", name.get(h), "setName()での処理が不正です!");
            //assertEquals(90, hp.get(h),"?90?");
        } catch (NoSuchFieldException nsfe) {
            fail("Heroクラスにフィールド name が定義されていません! ");
        } catch (NoSuchMethodException nsme) { // 2024Dec11 （大文字小文字も確認） を追加
            fail("HeroクラスにsetName(String 変数名)が定義されていない（大文字小文字も確認）、もしくはpublic宣言されていません! ");
        } catch (IllegalAccessException iae) {
            // クラスが public でなかったり、別のパッケージに入っていたりするために、実行中のメソッドが指定されたクラスの定義にアクセスできない場合にスローされる例外
            fail("HeroクラスのsetName()がpublic宣言されていません! ");
        } catch (java.lang.reflect.InvocationTargetException ite) {
            fail("setName()内で例外が発生しました"); // 教員対応
        }
    }

    @Test
    public void testSetHp() {
        try{
            // action
            Hero h = new Hero();
            //Method setName = h.getClass().getMethod("setName", String.class);
            Method setHp = h.getClass().getMethod("setHp", int.class);
            //setName.invoke(h, "二郎");
            setHp.invoke(h, 90);

            //Field name = h.getClass().getDeclaredField("name");
            Field hp = h.getClass().getDeclaredField("hp");

            //name.setAccessible(true);
            hp.setAccessible(true);

            //assertEquals("二郎", name.get(h));
            assertEquals(90, hp.get(h),"setHp()での処理が不正です!");
        } catch (NoSuchFieldException nsfe) {
            fail("Heroクラスにフィールド hp が定義されていません! ");
        } catch (NoSuchMethodException nsme) { // 2024Dec11 （大文字小文字も確認）を追加
            fail("HeroクラスにsetHp(int 変数名)が定義されていない（大文字小文字も確認）、もしくはpublic宣言されていません! ");
        } catch (IllegalAccessException iae) {
            // クラスが public でなかったり、別のパッケージに入っていたりするために、実行中のメソッドが指定されたクラスの定義にアクセスできない場合にスローされる例外
            fail("HeroクラスのsetHp()がpublic宣言されていません! ");
        } catch (java.lang.reflect.InvocationTargetException ite) {
            fail("setHp()内で例外が発生しました"); // 教員対応
        }
    }

    @Test
    public void testGetName() {
        try{
            // action
            Hero h = new Hero();
            Method getName = h.getClass().getMethod("getName");
            //Method getHp = h.getClass().getMethod("getHp");

            assertEquals("??", getName.invoke(h),"getName()の戻り値が不正です!");
            //assertEquals(0, getHp.invoke(h),"assdffg");

        } catch (NoSuchMethodException nsme) { // 2024Dec11 （大文字小文字も確認）を追加
            fail("HeroクラスにgetName()が定義されていない（大文字小文字も確認）、もしくはpublic宣言されていません! ");
        } catch (IllegalAccessException iae) {
            fail("HeroクラスのgetName()がpublic宣言されていません! ");
        } catch (java.lang.reflect.InvocationTargetException ite) {
            fail("getName()内で例外が発生しました"); // 教員対応
        }
    }

    @Test
    public void testGetHp() {
        try{
            // action
            Hero h = new Hero();
            //Method getName = h.getClass().getMethod("getName");
            Method getHp = h.getClass().getMethod("getHp");

            //assertEquals("??", getName.invoke(h));
            assertEquals(0, getHp.invoke(h),"Hero.GetHpの戻り値が不正です!");

        } catch (NoSuchMethodException nsme) { // 2024Dec11 （大文字小文字も確認）を追加
            fail("HeroクラスにgetHp()が定義されていない（大文字小文字も確認）、もしくはpublic宣言されていません! ");
        } catch (IllegalAccessException iae) {
            fail("HeroクラスのgetHp()がpublic宣言されていません! ");
        } catch (java.lang.reflect.InvocationTargetException ite) {
            fail("getHp()内で例外が発生しました"); // 教員対応
        }
    }
}
