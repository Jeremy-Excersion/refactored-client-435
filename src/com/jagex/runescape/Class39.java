package com.jagex.runescape;

import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.util.Signlink;

public class Class39 implements Runnable {
    public static RSString aClass1_898 = RSString.CreateString(" steht bereits auf Ihrer Freunde)2Liste(Q");
    public static RSString aClass1_899 = RSString.CreateString("Benutzen Sie bitte eine andere Welt)3");
    public static int anInt901;
    public static RSString aClass1_904 = RSString.CreateString(" more options");
    public static boolean aBoolean906 = false;
    public static Class68 aClass68_907;
    public static Class68 aClass68_908;
    public static int anInt909 = 0;
    public static RSString aClass1_910;
    public static RSString aClass1_911 = RSString.CreateString("Spiel)2Fenster geladen)3");
    public static int anInt912 = 20;
    public static RSString aClass1_914 = RSString.CreateString("Stufe)2");
    public static int anInt916;
    public static RSString aClass1_917 = RSString.CreateString(" from your ignore list first");
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_918;
    public static RSString str_ok = RSString.CreateString("Ok");
    public Object objectLock;
    public boolean aBoolean913 = true;
    public int[] coordsY;
    public int coord;
    public int[] coordsX;

    public Class39() {
        objectLock = new Object();
        coord = 0;
        coordsY = new int[500];
        coordsX = new int[500];
    }

    public static void method451(Class40_Sub3 arg0, int arg1) {
        int i = 0;
        int i_0_ = -1;
        int i_1_ = 0;
        if(arg0.anInt2027 == 0)
            i = (Npc.aScene_3301.method122(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038));
        int i_2_ = 0;
        if(arg0.anInt2027 == 1)
            i = (Npc.aScene_3301.method91(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038));
        if(arg0.anInt2027 == 2)
            i = (Npc.aScene_3301.getLocationHash(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038));
        if(arg0.anInt2027 == 3)
            i = (Npc.aScene_3301.getFloorDecorationHash(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038));
        if(arg1 == 19813) {
            if(i != 0) {
                int i_3_ = (Npc.aScene_3301.getArrangement(arg0.anInt2018, arg0.anInt2039, arg0.anInt2038, i));
                i_0_ = (0x1fffe692 & i) >> 14;
                i_2_ = (i_3_ & 0xde) >> 6;
                i_1_ = i_3_ & 0x1f;
            }
            arg0.anInt2025 = i_2_;
            arg0.anInt2028 = i_0_;
            arg0.anInt2036 = i_1_;
        }
    }

    public static boolean method452(Signlink arg0, byte arg1, boolean arg2) {
        RSCanvas.anInt54 = 20;
        anInt916++;
        try {
            Class5.aClass22_189 = new Class22_Sub2_Sub1(); // Java Midi Based
            return true;
        } catch(Throwable throwable) {
            Runnable_Impl1 runnable_impl1 = arg0.method391(1048576);
            if(runnable_impl1 != null) {
                Class5.aClass22_189 = new Class22_Sub2_Sub2(arg0, runnable_impl1); // ???
                return true;
            }
            if(arg1 < 6)
                aClass1_911 = null;
            if(arg2) {
                Class5.aClass22_189 = new Class22_Sub1(arg0); // JS based
                return true;
            }
            return false;
        }
//        return false;
    }

    public static void method453(byte arg0) {
        aClass68_907 = null;
        aClass1_899 = null;
        aClass1_917 = null;
        aClass1_911 = null;
        if(arg0 > -69)
            method451(null, 36);
        aClass40_Sub5_Sub14_Sub4_918 = null;
        aClass1_904 = null;
        str_ok = null;
        aClass1_914 = null;
        aClass1_898 = null;
        aClass68_908 = null;
        aClass1_910 = null;
    }

    public void run() {
        while(aBoolean913) {
            synchronized(objectLock) {
                if(coord < 500) {
                    coordsX[coord] = Class13.mouseX;
                    coordsY[coord] = Landscape.mouseY;
                    coord++;
                }
            }
            Class43.method890(50L, 44);
        }
    }
}
