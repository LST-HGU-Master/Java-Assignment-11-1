import org.junit.jupiter.api.Test;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

    @Test
    public void testPrivate() {
        try{
            // action
            Hero h = new Hero();
            Field name = h.getClass().getDeclaredField("name");
            Field hp = h.getClass().getDeclaredField("hp");

            assertEquals(Modifier.PRIVATE, name.getModifiers());
            assertEquals(Modifier.PRIVATE, hp.getModifiers());

        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }

    @Test
    public void testSetter() {
        try{
            // action
            Hero h = new Hero();
            Method setName = h.getClass().getMethod("setName", String.class);
            Method setHp = h.getClass().getMethod("setHp", int.class);
            setName.invoke(h, "二郎");
            setHp.invoke(h, 90);

            Field name = h.getClass().getDeclaredField("name");
            Field hp = h.getClass().getDeclaredField("hp");

            name.setAccessible(true);
            hp.setAccessible(true);

            assertEquals("二郎", name.get(h));
            assertEquals(90, hp.get(h));

        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }

    @Test
    public void testGetter() {
        try{
            // action
            Hero h = new Hero();
            Method getName = h.getClass().getMethod("getName");
            Method getHp = h.getClass().getMethod("getHp");

            assertEquals("??", getName.invoke(h));
            assertEquals(0, getHp.invoke(h));

        } catch (Exception e) {
            // なにかしら例外がでたらfailにする
            fail();
        }
    }

}
