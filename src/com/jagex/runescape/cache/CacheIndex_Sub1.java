package com.jagex.runescape.cache;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.media.renderable.actor.Npc;

public class CacheIndex_Sub1 extends CacheIndex {
    public static int anInt1792;
    public static int anInt1793;
    public static int anInt1794;
    public static int anInt1795;
    public static RSString aClass1_1798;
    public static RSString aClass1_1799;
    public static RSString aClass1_1801 = RSString.CreateString("Freunde");
    public static int anInt1803;
    public static int anInt1804;
    public static int anInt1805;
    public static int anInt1806;
    public static int anInt1808;
    public static int anInt1809;
    public static Npc[] aClass40_Sub5_Sub17_Sub4_Sub2Array1813;
    public static RSString aClass1_1814;
    public static int anInt1815;
    public static RSString aClass1_1816;
    public static int anInt1817;
    public static int anInt1818;
    public static int anInt1819;

    static {
        aClass1_1798 = RSString.CreateString("blinken1:");
        aClass1_1814 = RSString.CreateString("Das ist eine Mitglieder)2Welt(Q");
        aClass1_1799 = RSString.CreateString("Offline");
        aClass1_1816 = RSString.CreateString(" zuerst von Ihrer Freunde)2Liste(Q");
        anInt1819 = -1;
        aClass40_Sub5_Sub17_Sub4_Sub2Array1813 = new Npc[32768];
    }

    public volatile boolean[] aBooleanArray1796;
    public int anInt1797 = -1;
    public volatile boolean aBoolean1800 = false;
    public Class56 aClass56_1802;
    public int anInt1807;
    public int anInt1810;
    public boolean aBoolean1811 = false;
    public Class56 aClass56_1812;

    public CacheIndex_Sub1(Class56 arg0, Class56 arg1, int arg2, boolean arg3, boolean arg4, boolean arg5) {
        super(arg3, arg4);
        aClass56_1812 = arg0;
        aBoolean1811 = arg5;
        aClass56_1802 = arg1;
        anInt1807 = arg2;
        Main.method37(this, (byte) 98, anInt1807);

    }

    public static void method203(int arg0) {

        aClass1_1799 = null;
        aClass40_Sub5_Sub17_Sub4_Sub2Array1813 = null;
        aClass1_1801 = null;
        if(arg0 != 99)
            method203(24);
        aClass1_1798 = null;
        aClass1_1816 = null;
        aClass1_1814 = null;

    }

    public static RSString method204(int arg0, int arg1) {

        anInt1804++;
        if(arg1 != 255)
            method203(83);
        return (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{HashTable.method334(0xff & arg0 >> 24, -1), Node.aClass1_975, HashTable.method334((arg0 & 0xffca88) >> 16, -1), Node.aClass1_975, HashTable.method334((0xfff8 & arg0) >> 8, -1), Node.aClass1_975, HashTable.method334(0xff & arg0, -1)})));

    }

    public void method196(boolean arg0, int arg2, boolean arg3, byte[] arg4) {
        anInt1815++;
        if(arg0) {
            if(aBoolean1800)
                throw new RuntimeException();
            if(aClass56_1802 != null)
                RSRuntimeException.method1055(arg4, (byte) -54, aClass56_1802, anInt1807);
            this.method178(arg4);
            method199(-124);
        } else {
            arg4[arg4.length - 2] = (byte) (anIntArray224[arg2] >> 8);
            arg4[arg4.length + -1] = (byte) anIntArray224[arg2];
            if(aClass56_1812 != null) {
                RSRuntimeException.method1055(arg4, (byte) 55, aClass56_1812, arg2);
                aBooleanArray1796[arg2] = true;
            }
            if(arg3)
                aByteArrayArray212[arg2] = arg4;
        }
    }

    public int method197(int arg0) {

        anInt1808++;
        if(aBoolean1800)
            return 100;
        if(aByteArrayArray212 != null)
            return 99;
        int i = Class34.method415((byte) -103, 255, anInt1807);
        if(arg0 != 100)
            return -74;
        if(i >= 100)
            i = 99;
        return i;

    }

    public void method198(byte arg0, boolean arg1, byte[] arg2, int arg3, Class56 arg4) {
        do {
            anInt1794++;
            if(aClass56_1802 == arg4) {
                if(aBoolean1800)
                    throw new RuntimeException();
                    /*if(arg2 == null) {
                        com.jagex.runescape.HashTable.method327(true, this, 255, anInt1807, (byte) 0,
                                anInt1810, (byte) 85);
                        break;
                    }
                    com.jagex.runescape.Class65.aCRC32_1531.reset();
                    com.jagex.runescape.Class65.aCRC32_1531.update(arg2, 0, arg2.length);
                    int i = (int) com.jagex.runescape.Class65.aCRC32_1531.getValue();
                    if(i != anInt1810) {
                        com.jagex.runescape.HashTable.method327(true, this, 255, anInt1807, (byte) 0,
                                anInt1810, (byte) -121);
                        break;
                    }*/
                this.method178(arg2);
                method199(-112);
            } else {
                if(!arg1 && anInt1797 == arg3)
                    aBoolean1800 = true;
                if(arg2 == null || arg2.length <= 2) {
                    aBooleanArray1796[arg3] = false;
                    if(aBoolean1811 || arg1)
                        HashTable.method327(arg1, this, anInt1807, arg3, (byte) 2, anIntArray252[arg3], (byte) -117);
                    break;
                }
                Class65.aCRC32_1531.reset();
                Class65.aCRC32_1531.update(arg2, 0, arg2.length - 2);
                int i = (int) Class65.aCRC32_1531.getValue();
                int i_0_ = (((arg2[-2 + arg2.length] & 0xff) << 8) + (0xff & arg2[arg2.length + -1]));
                if(i != anIntArray252[arg3] || (i_0_ != anIntArray224[arg3])) {
                    aBooleanArray1796[arg3] = false;
                    if(aBoolean1811 || arg1)
                        HashTable.method327(arg1, this, anInt1807, arg3, (byte) 2, anIntArray252[arg3], (byte) -78);
                    break;
                }
                aBooleanArray1796[arg3] = true;
                if(arg1)
                    aByteArrayArray212[arg3] = arg2;
            }
            if(arg0 == -115)
                break;
            method197(-55);

            break;
        } while(false);
    }

    public void method177(int arg0, int arg1) {
        anInt1809++;
        if(aClass56_1812 != null && aBooleanArray1796 != null && aBooleanArray1796[arg1])
            GameObjectDefinition.method602(this, arg1, aClass56_1812, (byte) -125);
        else
            HashTable.method327(true, this, anInt1807, arg1, (byte) 2, anIntArray252[arg1], (byte) -127);
        if(arg0 <= 1)
            aBoolean1811 = true;
    }

    public void method174(int arg0, byte arg1) {
        Class32.method399(anInt1807, 33, arg0);
        anInt1805++;
        if(arg1 != 2)
            method174(13, (byte) 101);
    }

    public void method199(int arg0) {
        aBooleanArray1796 = new boolean[aByteArrayArray212.length];
        anInt1817++;
        int i = -58 % ((-44 - arg0) / 55);
        for(int i_1_ = 0; (i_1_ < aBooleanArray1796.length); i_1_++)
            aBooleanArray1796[i_1_] = false;
        if(aClass56_1812 == null)
            aBoolean1800 = true;
        else {
            anInt1797 = -1;
            for(int i_2_ = 0; (aBooleanArray1796.length > i_2_); i_2_++) {
                if(anIntArray261[i_2_] > 0) {
                    PacketBuffer.method513(i_2_, this, aClass56_1812, (byte) -28);
                    anInt1797 = i_2_;
                }
            }
            if(anInt1797 == -1)
                aBoolean1800 = true;
        }
    }

    public void method200(int arg0, int arg1) {

        if(arg1 >= 41) {
            anInt1818++;
            anInt1810 = arg0;
            if(aClass56_1802 == null)
                HashTable.method327(true, this, 255, anInt1807, (byte) 0, anInt1810, (byte) -118);
            else
                GameObjectDefinition.method602(this, anInt1807, aClass56_1802, (byte) -124);
        }

    }

    public int method201(int arg0, int arg1) {

        anInt1795++;
        int i = 124 / ((-6 - arg1) / 34);
        if(aByteArrayArray212[arg0] != null)
            return 100;
        if(aBooleanArray1796[arg0])
            return 100;
        return Class34.method415((byte) 88, anInt1807, arg0);

    }

    public int method202(boolean arg0) {

        int i = 0;
        anInt1803++;
        int i_3_ = 0;
        for(int i_4_ = 0; (i_4_ < aByteArrayArray212.length); i_4_++) {
            if(anIntArray261[i_4_] > 0) {
                i += 100;
                i_3_ += method201(i_4_, 28);
            }
        }
        if(arg0)
            method203(-91);
        if(i == 0)
            return 100;
        int i_5_ = i_3_ * 100 / i;
        return i_5_;

    }
}
