package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;

public class IdentityKit extends SubNode {
    public static RSString aClass1_2587;
    public static RSString aClass1_2588 = RSString.CreateString("backvmid2");
    public static HuffmanEncoding aHuffmanEncoding_2590;
    public static int anInt2591 = 0;
    public static RSString aClass1_2592 = RSString.CreateString("Anmelde)2Zeitlimit -Uberschritten)3");
    public static RSString aClass1_2593;
    public static RSString aClass1_2595 = RSString.CreateString("K");
    public static boolean aBoolean2597 = false;
    public static int anInt2598 = 0;
    public static int[] sound = new int[50];
    public static Class45 aClass45_2604 = new Class45();
    public static int height;
    public static CacheIndex_Sub1 aClass6_Sub1_2609;
    public static RSString aClass1_2611 = RSString.CreateString("Bitte versuchen Sie es in ");
    public static int anInt2613 = 0;
    public static RSString aClass1_2614 = RSString.CreateString("Wen m-Ochten Sie entfernen?");
    public static RSString aClass1_2615;
    public static RSString aClass1_2616 = RSString.CreateString("Bad session id)3");
    public static boolean membersServer;

    static {
        aClass1_2593 = aClass1_2595;
        aClass1_2587 = aClass1_2595;
        aClass1_2615 = aClass1_2616;
    }

    public int[] recolorToFind = new int[6];
    public int[] recolorToReplace;
    public int bodyPartId = -1;
    public int[] modelId;
    public boolean nonSelectable = false;
    public int[] models = {-1, -1, -1, -1, -1};

    public IdentityKit() {
        recolorToReplace = new int[6];
    }

    public static void method625(int arg0) {
        aClass1_2595 = null;
        aClass1_2615 = null;
        aClass1_2611 = null;
        aClass1_2588 = null;
        aClass6_Sub1_2609 = null;
        aHuffmanEncoding_2590 = null;
        aClass1_2616 = null;
        aClass1_2614 = null;
        aClass1_2592 = null;
        if(arg0 != 0) {
            method625(-67);
        }
        aClass1_2587 = null;
        aClass45_2604 = null;
        sound = null;
        aClass1_2593 = null;
    }

    public static Class40_Sub5_Sub1 method626(int arg0, int arg1, int arg2) {
        long l = (long) (arg0 + (arg1 << 16));
        Class40_Sub5_Sub1 class40_sub5_sub1 = ((Class40_Sub5_Sub1) Class17.aClass9_449.get(l, (byte) 72));
        if(class40_sub5_sub1 != null) {
            return class40_sub5_sub1;
        }
        byte[] is = (Class56.aClass6_Sub1_1323.method170(GameObject.aClass1_3044, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{HashTable.method334(arg1, -1), SubNode.aClass1_2084, HashTable.method334(arg0, -1)})), 1));
        if(arg2 <= 4) {
            return null;
        }
        Buffer class40_sub1 = new Buffer(is);
        class40_sub5_sub1 = new Class40_Sub5_Sub1();
        class40_sub1.currentPosition = class40_sub1.buffer.length + -12;
        int i = class40_sub1.getIntBE();
        int i_0_ = 0;
        class40_sub5_sub1.anInt2271 = class40_sub1.getUnsignedShortBE();
        class40_sub5_sub1.anInt2267 = class40_sub1.getUnsignedShortBE();
        class40_sub5_sub1.anInt2263 = class40_sub1.getUnsignedShortBE();
        class40_sub5_sub1.anInt2266 = class40_sub1.getUnsignedShortBE();
        class40_sub5_sub1.aClass1Array2270 = new RSString[i];
        class40_sub5_sub1.anIntArray2262 = new int[i];
        class40_sub1.currentPosition = 0;
        class40_sub5_sub1.anIntArray2272 = new int[i];
        while(class40_sub1.currentPosition < -12 + class40_sub1.buffer.length) {
            int i_1_ = class40_sub1.getUnsignedShortBE();
            if(i_1_ == 3) {
                class40_sub5_sub1.aClass1Array2270[i_0_] = class40_sub1.getRSString();
            } else if(i_1_ >= 100 || i_1_ == 21 || i_1_ == 38 || i_1_ == 39) {
                class40_sub5_sub1.anIntArray2262[i_0_] = class40_sub1.getUnsignedByte();
            } else {
                class40_sub5_sub1.anIntArray2262[i_0_] = class40_sub1.getIntBE();
            }
            class40_sub5_sub1.anIntArray2272[i_0_++] = i_1_;
        }
        Class17.aClass9_449.put(-7208, l, class40_sub5_sub1);
        return class40_sub5_sub1;
    }

    public static RSString method627(int arg0, int arg1, int arg2, RSString[] arg3) {
        int i = 0;
        int i_2_ = 6 / ((arg0 - 6) / 52);
        for(int i_3_ = 0; i_3_ < arg1; i_3_++) {
            if(arg3[arg2 + i_3_] == null) {
                arg3[i_3_ + arg2] = RSApplet.aClass1_28;
            }
            i += arg3[i_3_ + arg2].length;
        }
        byte[] is = new byte[i];
        int i_4_ = 0;
        for(int i_5_ = 0; i_5_ < arg1; i_5_++) {
            RSString class1 = arg3[arg2 + i_5_];
            Class18.method278(class1.chars, 0, is, i_4_, class1.length);
            i_4_ += class1.length;
        }
        RSString class1 = new RSString();
        class1.length = i;
        class1.chars = is;
        return class1;
    }

    // ???
    public static IdentityKit cache(int arg1) {
        IdentityKit identityKit = ((IdentityKit) Class68.aClass9_1615.get((long) arg1, (byte) 107));
        if(identityKit != null) {
            return identityKit;
        }
        byte[] is = Class49.aCacheIndex_1150.getFile(arg1, 3);
        identityKit = new IdentityKit();
        if(is != null) {
            identityKit.readValues(new Buffer(is));
        }
        Class68.aClass9_1615.put(-7208, (long) arg1, identityKit);
        return identityKit;

    }

    public void readValues(Buffer buffer) {
        while(true) {
            int opcode = buffer.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(buffer, opcode);
        }
    }

    public boolean isBodyModelCached() {
        if(modelId == null) {
            return true;
        }
        boolean isCached = true;
        for(int i = 0; modelId.length > i; i++) {
            if(!Class27.aCacheIndex_654.loaded(modelId[i], 0)) {
                isCached = false;
            }
        }
        return isCached;
    }

    public boolean method624(boolean arg0) {
        boolean bool = true;
        int i = 0;
        if(arg0) {
            return false;
        }
        for(/**/; i < 5; i++) {
            if(models[i] != -1 && !Class27.aCacheIndex_654.loaded(models[i], 0)) {
                bool = false;
            }
        }
        return bool;
    }

    public void readValue(Buffer buffer, int opcode) {
        if(opcode == 1) {
            bodyPartId = buffer.getUnsignedByte();
        } else if(opcode == 2) {
            int modelCount = buffer.getUnsignedByte();
            modelId = new int[modelCount];
            for(int model = 0; model < modelCount; model++) {
                modelId[model] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 3) {
            nonSelectable = true;
        } else if(opcode >= 40 && opcode < 50) {
            recolorToFind[opcode + -40] = buffer.getUnsignedShortBE();
        } else if(opcode >= 50 && opcode < 60) {
            recolorToReplace[-50 + opcode] = buffer.getUnsignedShortBE();
        } else if(opcode >= 60 && opcode < 70) {
            models[-60 + opcode] = buffer.getUnsignedShortBE();
        }
    }

    public Model method629(byte arg0) {
        Model[] class40_sub5_sub17_sub5s = new Model[5];
        int i = 0;
        if(arg0 != -100) {
            return null;
        }
        for(int i_7_ = 0; i_7_ < 5; i_7_++) {
            if(models[i_7_] != -1) {
                class40_sub5_sub17_sub5s[i++] = Model.getModel((Class27.aCacheIndex_654), (models[i_7_]), 0);
            }
        }
        Model class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, i);
        for(int i_8_ = 0; i_8_ < 6; i_8_++) {
            if(recolorToFind[i_8_] == 0) {
                break;
            }
            class40_sub5_sub17_sub5.replaceColor(recolorToFind[i_8_], recolorToReplace[i_8_]);
        }
        return class40_sub5_sub17_sub5;
    }

    public Model getBodyModel(boolean arg0) {
        if(modelId == null) {
            return null;
        }
        Model[] models = new Model[modelId.length];
        for(int i = 0; i < modelId.length; i++) {
            models[i] = Model.getModel(Class27.aCacheIndex_654, modelId[i], 0);
        }
        Model model;
        if(models.length == 1) {
            model = models[0];
        } else {
            model = (new Model(models, models.length));
        }
        if(arg0) {
            return null;
        }
        for(int i = 0; i < 6; i++) {
            if(recolorToFind[i] == 0) {
                break;
            }
            model.replaceColor(recolorToFind[i], recolorToReplace[i]);
        }
        return model;
    }
}
