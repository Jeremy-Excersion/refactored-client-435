package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;

public class Class5 {
    public static Class22 aClass22_189;
    public static int[] itemSearchResultIds = new int[100];
    public static RSString aClass1_193 = RSString.CreateString("Please contact customer support)3");
    public static int anInt194;
    public static int anInt195 = 1;
    public static RSString aClass1_196 = RSString.CreateString("backvmid3");
    public static int[] anIntArray198;
    public static int anInt199 = 0;
    public static int anInt200 = 127;
    public static RSString aClass1_203 = RSString.CreateString("mapmarker");
    public static RSString aClass1_204 = RSString.CreateString("red:");
    public static RSString aClass1_206 = RSString.CreateString(" )2> @lre@");
    public static int currentTabId = 3;

    public static void method162(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, byte[] arg8, CollisionMap[] arg9) {
        if(arg1 != 13941)
            method162(53, -59, 8, -121, -68, -3, -42, -91, null, null);
        for(int i = 0; i < 8; i++) {
            for(int i_0_ = 0; i_0_ < 8; i_0_++) {
                if(arg5 + i > 0 && i + arg5 < 103 && arg0 + i_0_ > 0 && i_0_ + arg0 < 103)
                    arg9[arg4].anIntArrayArray150[arg5 + i][i_0_ + arg0] = HuffmanEncoding.method1021((arg9[arg4].anIntArrayArray150[arg5 + i][i_0_ + arg0]), -16777217);
            }
        }
        Buffer class40_sub1 = new Buffer(arg8);
        for(int i = 0; i < 4; i++) {
            for(int i_1_ = 0; i_1_ < 64; i_1_++) {
                for(int i_2_ = 0; i_2_ < 64; i_2_++) {
                    if(i == arg3 && i_1_ >= arg2 && 8 + arg2 > i_1_ && i_2_ >= arg6 && 8 + arg6 > i_2_)
                        Class48.method922(arg5 + Class24.method338(arg7, false, i_1_ & 0x7, i_2_ & 0x7), arg7, class40_sub1, arg1 ^ ~0x363e, arg0 + Class33.method410(i_1_ & 0x7, 0x7 & i_2_, arg7, false), 0, 0, arg4);
                    else
                        Class48.method922(-1, 0, class40_sub1, -116, -1, 0, 0, 0);
                }
            }
        }
    }

    public static void method163(byte arg0) {
        aClass1_196 = null;
        if(arg0 == -94) {
            aClass1_204 = null;
            aClass1_206 = null;
            itemSearchResultIds = null;
            aClass22_189 = null;
            aClass1_203 = null;
            aClass1_193 = null;
            anIntArray198 = null;
        }
    }

    public static void method164(int arg0) {
        Renderable.handleSequences(arg0 + 29378, ActorDefinition.openFullScreenWidgetId);
        if(arg0 != (UnderlayDefinition.openSecondaryWidgetId ^ 0xffffffff))
            Renderable.handleSequences(arg0 + 29378, UnderlayDefinition.openSecondaryWidgetId);
        anInt199 = 0;
        Class68_Sub1.aClass68_2213.method1046((byte) 90);
        Player.anIntArray3284 = Rasterizer3D.method708(Player.anIntArray3284);
        Rasterizer.resetPixels();
        Class40_Sub5_Sub6.drawInterface(0, ActorDefinition.openFullScreenWidgetId, 503, (byte) -5, 0, 0, 765);
        if(UnderlayDefinition.openSecondaryWidgetId != -1)
            Class40_Sub5_Sub6.drawInterface(0, UnderlayDefinition.openSecondaryWidgetId, 503, (byte) -5, 0, 0, 765);
        if(!Class4.menuOpen) {
            Class43.method894(false);
            SceneTile.method537(4);
        } else
            Class40_Sub5_Sub6.method588(-1);
        try {
            Graphics graphics = GameFrame.aCanvas1469.getGraphics();
            Class68_Sub1.aClass68_2213.method1044(0, 0, graphics, 0);
        } catch(Exception exception) {
            GameFrame.aCanvas1469.repaint();
        }
    }

    public static void method165(int arg0) {
        int i = 64 + Class32.anInt767 * 128;
        int i_3_ = 64 + 128 * Class22.anInt545;
        int i_4_ = (Class37.method430((byte) -121, Player.anInt3267, i_3_, i) + -anInt194);
        if((i_3_ > Class12.cameraX)) {
            Class12.cameraX += (Class59.anInt1386 * (i_3_ + -Class12.cameraX) / 1000 + Class4.anInt188);
            if(Class12.cameraX > i_3_) {
                Class12.cameraX = i_3_;
            }
        }
        if((i_4_ > Class32.cameraZ)) {
            Class32.cameraZ += (Class59.anInt1386 * (i_4_ - Class32.cameraZ) / 1000 + Class4.anInt188);
            if((i_4_ < Class32.cameraZ))
                Class32.cameraZ = i_4_;
        }
        if((Class12.cameraX > i_3_)) {
            Class12.cameraX -= Class4.anInt188 + (Class59.anInt1386 * (Class12.cameraX + -i_3_) / 1000);
            if(i_3_ > Class12.cameraX) {
                Class12.cameraX = i_3_;
            }
        }
        if((Class40_Sub5_Sub6.cameraY < i)) {
            Class40_Sub5_Sub6.cameraY += Class4.anInt188 + (Class59.anInt1386 * (-Class40_Sub5_Sub6.cameraY + i) / 1000);
            if((Class40_Sub5_Sub6.cameraY > i))
                Class40_Sub5_Sub6.cameraY = i;
        }
        if(Class32.cameraZ > i_4_) {
            Class32.cameraZ -= ((Class32.cameraZ + -i_4_) * Class59.anInt1386 / 1000 + Class4.anInt188);
            if((i_4_ > Class32.cameraZ))
                Class32.cameraZ = i_4_;
        }
        i_3_ = 64 + HashTable.anInt564 * 128;
        if(Class40_Sub5_Sub6.cameraY > i) {
            Class40_Sub5_Sub6.cameraY -= Class4.anInt188 + (Class59.anInt1386 * (Class40_Sub5_Sub6.cameraY - i) / 1000);
            if(Class40_Sub5_Sub6.cameraY < i)
                Class40_Sub5_Sub6.cameraY = i;
        }
        i = UnderlayDefinition.anInt2576 * 128 + 64;
        i_4_ = Class37.method430((byte) -125, Player.anInt3267, i_3_, i) - Class38.anInt892;
        int i_5_ = -Class32.cameraZ + i_4_;
        int i_6_ = i - Class40_Sub5_Sub6.cameraY;
        int i_7_ = i_3_ - Class12.cameraX;
        int i_8_ = (int) Math.sqrt((double) (i_7_ * i_7_ + (i_6_ * i_6_)));
        int i_9_ = 0x7ff & (int) (Math.atan2((double) i_5_, (double) i_8_) * 325.949);
        if(i_9_ < 128)
            i_9_ = 128;
        int i_10_ = 0x7ff & (int) (-325.949 * Math.atan2((double) i_7_, (double) i_6_));
        if(i_9_ > 383)
            i_9_ = 383;
        int i_11_ = -Class68_Sub1.anInt2210 + i_10_;
        if(i_11_ > 1024)
            i_11_ -= 2048;
        if(i_11_ < -1024)
            i_11_ += 2048;
        if(i_11_ > 0) {
            Class68_Sub1.anInt2210 += Class22_Sub1.anInt1856 * i_11_ / 1000 + Class60.anInt1413;
            Class68_Sub1.anInt2210 &= 0x7ff;
        }
        if(arg0 > 0) {
            if(i_11_ < 0) {
                Class68_Sub1.anInt2210 -= Class60.anInt1413 + (Class22_Sub1.anInt1856 * -i_11_ / 1000);
                Class68_Sub1.anInt2210 &= 0x7ff;
            }
            if(i_9_ > Class26.anInt627) {
                Class26.anInt627 += Class60.anInt1413 + (Class22_Sub1.anInt1856 * (i_9_ - Class26.anInt627) / 1000);
                if(Class26.anInt627 > i_9_)
                    Class26.anInt627 = i_9_;
            }
            if(Class26.anInt627 > i_9_) {
                Class26.anInt627 -= (Class22_Sub1.anInt1856 * (Class26.anInt627 + -i_9_) / 1000) + Class60.anInt1413;
                if(Class26.anInt627 < i_9_)
                    Class26.anInt627 = i_9_;
            }
            int i_12_ = i_10_ + -Class68_Sub1.anInt2210;
            if(i_12_ > 1024)
                i_12_ -= 2048;
            if(i_12_ < -1024)
                i_12_ += 2048;
            if(i_12_ < 0 && i_11_ > 0 || i_12_ > 0 && i_11_ < 0)
                Class68_Sub1.anInt2210 = i_10_;
        }
    }

    public static boolean method166(byte arg0, Widget arg1) {
        int i = arg1.contentType;
        if(Class12.friendListStatus == 2) {
            if(i == 201) {
                Class37.anInt876 = 1;
                HuffmanEncoding.aClass1_1563 = Widget.aClass1_2740;
                InteractiveObject.messagePromptRaised = true;
                Class40_Sub5_Sub15.inputType = 0;
                HuffmanEncoding.aClass1_1565 = HuffmanEncoding.blank_string;
                Class52.redrawChatbox = true;
            }
            if(i == 202) {
                Class37.anInt876 = 2;
                HuffmanEncoding.aClass1_1563 = Class13.aClass1_417;
                Class52.redrawChatbox = true;
                Class40_Sub5_Sub15.inputType = 0;
                InteractiveObject.messagePromptRaised = true;
                HuffmanEncoding.aClass1_1565 = HuffmanEncoding.blank_string;
            }
        }
        if(i == 205) {
            Class32.anInt771 = 250;
            return true;
        }
        if(i == 501) {
            Class40_Sub5_Sub15.inputType = 0;
            Class37.anInt876 = 4;
            Class52.redrawChatbox = true;
            HuffmanEncoding.aClass1_1563 = Class51.aClass1_1200;
            HuffmanEncoding.aClass1_1565 = HuffmanEncoding.blank_string;
            InteractiveObject.messagePromptRaised = true;
        }
        if(i == 502) {
            Class52.redrawChatbox = true;
            Class40_Sub5_Sub15.inputType = 0;
            Class37.anInt876 = 5;
            InteractiveObject.messagePromptRaised = true;
            HuffmanEncoding.aClass1_1565 = HuffmanEncoding.blank_string;
            HuffmanEncoding.aClass1_1563 = Class12.aClass1_399;
        }
        if(i >= 300 && i <= 313) {
            int i_13_ = (-300 + i) / 2;
            int i_14_ = 0x1 & i;
            Class45.aClass30_1082.method382(i_13_, i_14_ == 1, 14);
        }
        if(i >= 314 && i <= 323) {
            int i_15_ = (i + -314) / 2;
            int i_16_ = i & 0x1;
            Class45.aClass30_1082.method384(-94, i_16_ == 1, i_15_);
        }
        if(arg0 != 88)
            method163((byte) 42);
        if(i == 324)
            Class45.aClass30_1082.method383(false, (byte) -110);
        if(i == 325)
            Class45.aClass30_1082.method383(true, (byte) -110);
        if(i == 326) {
            Class22_Sub1.anInt1869++;
            Class32.packetBuffer.putPacket(231);
            Class45.aClass30_1082.method375(arg0 ^ 0x58, Class32.packetBuffer);
            return true;
        }
        if(i == 620)
            Class67.reportMutePlayer = !Class67.reportMutePlayer;
        if(i >= 601 && i <= 613) {
            PacketBuffer.method516(123);
            if(HuffmanEncoding.aClass1_1550.length() > 0) {
                Class32.packetBuffer.putPacket(202);
                Class32.packetBuffer.putLongBE(HuffmanEncoding.aClass1_1550.method58((byte) 102));
                Class32.packetBuffer.putByte(-601 + i);
                Class32.packetBuffer.putByte(Class67.reportMutePlayer ? 1 : 0);
            }
        }
        return false;
    }

    public static void method167(int arg0) {
        if(arg0 != 1023)
            method164(89);
        Class13.aClass9_406.method235((byte) -56);
    }

    public static void scrollInterface(int arg0, int arg1, int arg2, int arg3, byte arg4, Widget arg5, int arg6, int arg7, int arg8) {
        if(Class61.aBoolean1444)
            Landscape.anInt1171 = 32;
        else
            Landscape.anInt1171 = 0;
        Class61.aBoolean1444 = false;
        if(arg2 >= arg6 && arg2 < arg6 + 16 && arg1 >= arg8 && 16 + arg8 > arg1) {
            arg5.scrollPosition -= Npc.anInt3294 * 4;
            if(arg7 == 1)
                ISAAC.redrawTabArea = true;
            if(arg7 == 2 || arg7 == 3)
                Class52.redrawChatbox = true;
        } else if(arg6 > arg2 || (arg6 + 16 <= arg2) || arg1 < arg8 + arg0 + -16 || arg1 >= arg8 + arg0) {
            if(-Landscape.anInt1171 + arg6 <= arg2 && 16 + (arg6 + Landscape.anInt1171) > arg2 && arg8 + 16 <= arg1 && arg1 < -16 + arg8 + arg0 && Npc.anInt3294 > 0) {
                Class61.aBoolean1444 = true;
                int i = (-32 + arg0) * arg0 / arg3;
                if(arg7 == 2 || arg7 == 3)
                    Class52.redrawChatbox = true;
                if(arg7 == 1)
                    ISAAC.redrawTabArea = true;
                if(i < 8)
                    i = 8;
                int i_17_ = -i + (arg0 + -32);
                int i_18_ = -(i / 2) + (-arg8 + arg1) + -16;
                arg5.scrollPosition = (arg3 + -arg0) * i_18_ / i_17_;
            }
        } else {
            arg5.scrollPosition += 4 * Npc.anInt3294;
            if(arg7 == 2 || arg7 == 3)
                Class52.redrawChatbox = true;
            if(arg7 == 1)
                ISAAC.redrawTabArea = true;
        }
        int i = -61 / ((arg4 + 67) / 59);
    }
}
