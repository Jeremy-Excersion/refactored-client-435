package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class29 {
    public static int anInt669;
    public static RSString aClass1_670 = RSString.CreateString("@or3@");
    public static RSString aClass1_671 = RSString.CreateString("mapscene");
    public static int anInt672;
    public static int tabAreaOverlayWidgetId = -1;
    public static RSString aClass1_674 = RSString.CreateString(" x");
    public static int anInt675;
    public static Class64 aClass64_676;
    public static int anInt677;
    public static int anInt678 = 0;
    public static int anInt679;

    public static void method370(int arg0) {
        aClass1_674 = null;
        aClass1_670 = null;
        aClass1_671 = null;
        aClass64_676 = null;
        if(arg0 != 8)
            tabAreaOverlayWidgetId = 83;
    }

    public static boolean method371(int arg0, int arg1, int arg2) {

        anInt669++;
        if(arg1 == 0 && ItemDefinition.anInt2850 == arg2)
            return true;
        if(arg1 == 1 && arg2 == CollisionMap.anInt163)
            return true;
        if((arg1 == 2 || arg1 == 3) && Class55.anInt1296 == arg2)
            return true;
        return arg0 != 8247;

    }

    public static int method372(int arg0, int arg1) {

        anInt672++;
        if(arg0 <= 92)
            method372(4, 3);
        return (int) (0.5 + (Math.log(0.00390625 * (double) arg1) * 868.5889638065036));

    }

    public static void method373(byte arg0) {

        anInt679++;
        int i = Cache.outgoingbuffer.getBits(8, (byte) -65);
        if(i < Class60.anInt1407) {
            for(int i_0_ = i; Class60.anInt1407 > i_0_; i_0_++)
                CacheIndex.anIntArray225[Class17.anInt460++] = Class57.anIntArray1334[i_0_];
        }
        if(Class60.anInt1407 < i)
            throw new RuntimeException("gppov1");
        Class60.anInt1407 = 0;
        if(arg0 != -5)
            method370(45);
        for(int i_1_ = 0; (i > i_1_); i_1_++) {
            int i_2_ = Class57.anIntArray1334[i_1_];
            Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_2_]);
            int i_3_ = Cache.outgoingbuffer.getBits(1, (byte) -65);
            if(i_3_ == 0) {
                Class57.anIntArray1334[Class60.anInt1407++] = i_2_;
                class40_sub5_sub17_sub4_sub1.anInt3134 = Node.pulseCycle;
            } else {
                int i_4_ = Cache.outgoingbuffer.getBits(2, (byte) -65);
                if(i_4_ == 0) {
                    Class57.anIntArray1334[Class60.anInt1407++] = i_2_;
                    class40_sub5_sub17_sub4_sub1.anInt3134 = Node.pulseCycle;
                    Class24.anIntArray578[Actor.anInt3153++] = i_2_;
                } else if(i_4_ == 1) {
                    Class57.anIntArray1334[Class60.anInt1407++] = i_2_;
                    class40_sub5_sub17_sub4_sub1.anInt3134 = Node.pulseCycle;
                    int i_5_ = Cache.outgoingbuffer.getBits(3, (byte) -65);
                    class40_sub5_sub17_sub4_sub1.method782(i_5_, (byte) -96, false);
                    int i_6_ = Cache.outgoingbuffer.getBits(1, (byte) -65);
                    if(i_6_ == 1)
                        Class24.anIntArray578[Actor.anInt3153++] = i_2_;
                } else if(i_4_ == 2) {
                    Class57.anIntArray1334[Class60.anInt1407++] = i_2_;
                    class40_sub5_sub17_sub4_sub1.anInt3134 = Node.pulseCycle;
                    int i_7_ = Cache.outgoingbuffer.getBits(3, (byte) -65);
                    class40_sub5_sub17_sub4_sub1.method782(i_7_, (byte) -96, true);
                    int i_8_ = Cache.outgoingbuffer.getBits(3, (byte) -65);
                    class40_sub5_sub17_sub4_sub1.method782(i_8_, (byte) -96, true);
                    int i_9_ = Cache.outgoingbuffer.getBits(1, (byte) -65);
                    if(i_9_ == 1)
                        Class24.anIntArray578[Actor.anInt3153++] = i_2_;
                } else if(i_4_ == 3)
                    CacheIndex.anIntArray225[Class17.anInt460++] = i_2_;
            }
        }

    }
}
