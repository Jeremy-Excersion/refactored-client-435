package com.jagex.runescape;

import com.jagex.runescape.audio.Filter;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.*;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;

import java.net.InetAddress;
import java.net.Socket;

public class Main extends RSApplet {
    public static int anInt1756 = 0;
    public static RSString aClass1_1757 = RSString.CreateString("Runescape wurde aktualisiert(Q");
    public static int anInt1758;
    public static RSString aClass1_1761 = RSString.CreateString("Welcome to Runescape");
    public static RSString aClass1_1762 = RSString.CreateString("logo");
    public static RSString aClass1_1763 = RSString.CreateString("Use");
    public static int anInt1764 = 0;
    public static int anInt1766 = 1;
    public static int anInt1769 = -1;
    public static int anInt1773 = 0;
    public static RSString aClass1_1777 = RSString.CreateString("Verbinde mit Server)3)3)3");
    public static RSString[] aClass1Array1778 = new RSString[5];
    public static RSString aClass1_1781 = (RSString.CreateString("Account locked as we suspect it has been stolen)3"));
    public static RSString aClass1_1788 = RSString.CreateString("backtop1");
    public static boolean aBoolean1790;

    public static boolean method36(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Widget[] arg8, boolean arg9) {
        Rasterizer.setCoordinates(arg2, arg1, arg5, arg6);
        boolean bool = arg9;
        for(int i = 0; arg8.length > i; i++) {
            Widget widget = arg8[i];
            if(widget != null && widget.parentId == arg4) {
                if(widget.contentType > 0)
                    Widget.updateWidget(widget);
                int i_0_ = arg2 + widget.currentX;
                if(!widget.aBoolean2694)
                    i_0_ -= arg3;
                int i_1_ = arg1 + widget.currentY;
                if(!widget.aBoolean2694)
                    i_1_ -= arg7;
                int i_2_ = widget.opacity;
                if(widget == Wall.aWidget_353) {
                    i_2_ = 128;
                    Widget widget_3_ = Class40_Sub13.method878(-1598852880, widget);
                    int[] is = Class13.method247(widget_3_, (byte) 117);
                    int[] is_4_ = Class13.method247(widget, (byte) 97);
                    int i_5_ = (Landscape.mouseY + (-Class40_Sub5_Sub11.anInt2621 + (is_4_[1] - is[1])));
                    if(i_5_ < 0)
                        i_5_ = 0;
                    if(i_5_ + widget.originalHeight > widget_3_.originalHeight)
                        i_5_ = (widget_3_.originalHeight + -widget.originalHeight);
                    i_1_ = i_5_ + is[1];
                    int i_6_ = (Class13.mouseX + (-Class40_Sub2.anInt1996 + -is[0]) + is_4_[0]);
                    if(i_6_ < 0)
                        i_6_ = 0;
                    if((i_6_ + widget.originalWidth > widget_3_.originalWidth))
                        i_6_ = (-widget.originalWidth + widget_3_.originalWidth);
                    i_0_ = is[0] + i_6_;
                }
                if(!widget.isIf3 || (Rasterizer.viewport_right >= i_0_ && ((Rasterizer.viewport_bottom >= i_1_)) && ((Rasterizer.viewport_left <= i_0_ + widget.originalWidth)) && ((i_1_ + widget.originalHeight >= Rasterizer.viewport_top)))) {
                    if(widget.type == 0) {
                        if(widget.isHidden && !Class29.method371(8247, arg0, i))
                            continue;
                        if(!widget.isIf3) {
                            if((-widget.originalHeight + widget.scrollHeight) < widget.scrollPosition)
                                widget.scrollPosition = (-widget.originalHeight + widget.scrollHeight);
                            if(widget.scrollPosition < 0)
                                widget.scrollPosition = 0;
                        }
                        bool &= method36(arg0, i_1_, i_0_, widget.anInt2746, i, (widget.originalHeight + i_1_), (widget.originalWidth + i_0_), widget.scrollPosition, arg8, arg9);
                        if(widget.aWidgetArray2713 != null)
                            bool &= (method36(arg0, i_1_, i_0_, widget.anInt2746, widget.id, i_1_ + widget.originalHeight, widget.originalWidth + i_0_, widget.scrollPosition, (widget.aWidgetArray2713), true));
                        Rasterizer.setCoordinates(arg2, arg1, arg5, arg6);
                        if((widget.originalHeight < widget.scrollHeight))
                            Class27.drawScrollBar(0, widget.scrollPosition, widget.scrollHeight, i_0_ + (widget.originalWidth), widget.originalHeight, i_1_);
                    }
                    if(widget.type != 1) {
                        if(widget.type == 2) {
                            int i_7_ = 0;
                            for(int i_8_ = 0; ((i_8_ < widget.originalHeight)); i_8_++) {
                                for(int i_9_ = 0; widget.originalWidth > i_9_; i_9_++) {
                                    int i_10_ = ((widget.itemSpritePadsX + 32) * i_9_ + i_0_);
                                    int i_11_ = ((32 + (widget.itemSpritePadsY)) * i_8_ + i_1_);
                                    if(i_7_ < 20) {
                                        i_10_ += (widget.images[i_7_]);
                                        i_11_ += (widget.imageX[i_7_]);
                                    }
                                    if((widget.items[i_7_]) <= 0) {
                                        if((widget.imageY) != null && i_7_ < 20) {
                                            ImageRGB class40_sub5_sub14_sub4 = (widget.method638((byte) 78, i_7_));
                                            if(class40_sub5_sub14_sub4 == null) {
                                                if(Class40_Sub13.aBoolean2177)
                                                    bool = false;
                                            } else
                                                class40_sub5_sub14_sub4.drawImage(i_10_, i_11_);
                                        }
                                    } else {
                                        int i_12_ = 0;
                                        int i_13_ = -1 + (widget.items[i_7_]);
                                        int i_14_ = 0;
                                        if((-32 + (Rasterizer.viewport_left) < i_10_ && ((Rasterizer.viewport_right) > i_10_) && (((Rasterizer.viewport_top) + -32 < i_11_)) && (Rasterizer.viewport_bottom) > i_11_) || (SceneTile.activeInterfaceType != 0 && (GroundItemTile.selectedInventorySlot == i_7_))) {
                                            int i_15_ = 0;
                                            if(Class8.anInt301 == 1 && (i_7_ == Class45.anInt1061) && ((widget.id) == ISAAC.anInt525))
                                                i_15_ = 16777215;
                                            ImageRGB class40_sub5_sub14_sub4 = (Class40_Sub13.method876(117, (widget.itemAmounts[i_7_]), i_13_, i_15_));
                                            if(class40_sub5_sub14_sub4 == null)
                                                bool = false;
                                            else {
                                                if(SceneTile.activeInterfaceType != 0 && ((GroundItemTile.selectedInventorySlot) == i_7_) && ((widget.id) == (Class48.modifiedWidgetId))) {
                                                    i_14_ = ((Landscape.mouseY) + -(ItemDefinition.anInt2798));
                                                    i_12_ = (Class13.mouseX + -(Renderable.anInt2869));
                                                    if(i_12_ < 5 && i_12_ > -5)
                                                        i_12_ = 0;
                                                    if(i_14_ < 5 && (i_14_ > -5))
                                                        i_14_ = 0;
                                                    if((Buffer.anInt1978) < 5) {
                                                        i_14_ = 0;
                                                        i_12_ = 0;
                                                    }
                                                    class40_sub5_sub14_sub4.method728(i_12_ + i_10_, i_11_ + i_14_, 128);
                                                    if(arg4 != -1) {
                                                        Widget widget_16_ = arg8[arg4];
                                                        if(((Rasterizer.viewport_top) > i_14_ + i_11_) && ((widget_16_.scrollPosition) > 0)) {
                                                            int i_17_ = ((Class5.anInt199) * ((Rasterizer.viewport_top) + -i_11_ - i_14_) / 3);
                                                            if((10 * (Class5.anInt199)) < i_17_)
                                                                i_17_ = (10 * Class5.anInt199);
                                                            if((widget_16_.scrollPosition) < i_17_)
                                                                i_17_ = (widget_16_.scrollPosition);
                                                            widget_16_.scrollPosition -= i_17_;
                                                            ItemDefinition.anInt2798 += i_17_;
                                                        }
                                                        if(((32 + i_11_ + i_14_) > (Rasterizer.viewport_bottom)) && ((-(widget_16_.originalHeight) + (widget_16_.scrollHeight)) > (widget_16_.scrollPosition))) {
                                                            int i_18_ = ((Class5.anInt199) * (-(Rasterizer.viewport_bottom) + 32 + (i_11_ + i_14_)) / 3);
                                                            if(((Class5.anInt199) * 10) < i_18_)
                                                                i_18_ = (10 * Class5.anInt199);
                                                            if((-(widget_16_.scrollPosition) + (widget_16_.scrollHeight) + -(widget_16_.originalHeight)) < i_18_)
                                                                i_18_ = (-widget_16_.originalHeight + widget_16_.scrollHeight + -widget_16_.scrollPosition);
                                                            ItemDefinition.anInt2798 -= i_18_;
                                                            widget_16_.scrollPosition += i_18_;
                                                        }
                                                    }
                                                } else if((Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType) == 0 || ((Class52.anInt1233) != i_7_) || ((widget.id) != (Class30.anInt704)))
                                                    class40_sub5_sub14_sub4.drawImage(i_10_, i_11_);
                                                else
                                                    class40_sub5_sub14_sub4.method728(i_10_, i_11_, 128);
                                                if((class40_sub5_sub14_sub4.maxWidth) == 33 || (widget.itemAmounts[i_7_]) != 1) {
                                                    int i_19_ = (widget.itemAmounts[i_7_]);
                                                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.drawString((Widget.method648(i_19_, (byte) -100)), i_12_ + (1 + i_10_), (i_11_ + 10 + i_14_), 0);
                                                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.drawString((Widget.method648(i_19_, (byte) -100)), i_10_ + i_12_, i_14_ + (i_11_ + 9), 16776960);
                                                }
                                            }
                                        }
                                    }
                                    i_7_++;
                                }
                            }
                        } else if(widget.type == 3) {
                            int i_20_;
                            if(ItemDefinition.method746(widget)) {
                                i_20_ = widget.alternateTextColor;
                                if(Class29.method371(8247, arg0, i) && widget.alternateHoveredTextColor != 0)
                                    i_20_ = widget.alternateHoveredTextColor;
                            } else {
                                i_20_ = widget.textColor;
                                if(Class29.method371(8247, arg0, i) && widget.hoveredTextColor != 0)
                                    i_20_ = widget.hoveredTextColor;
                            }
                            if(i_2_ == 0) {
                                if(!widget.filled)
                                    Rasterizer.drawUnfilledRectangle(i_0_, i_1_, widget.originalWidth, widget.originalHeight, i_20_);
                                else
                                    Rasterizer.drawFilledRectangle(i_0_, i_1_, widget.originalWidth, widget.originalHeight, i_20_);
                            } else if(!widget.filled)
                                Rasterizer.drawUnfilledRectangleAlpha(i_0_, i_1_, widget.originalWidth, widget.originalHeight, i_20_, -(0xff & i_2_) + 256);
                            else
                                Rasterizer.drawFilledRectangleAlpha(i_0_, i_1_, widget.originalWidth, widget.originalHeight, i_20_, -(0xff & i_2_) + 256);
                        } else if(widget.type == 4) {
                            TypeFace class40_sub5_sub14_sub1 = widget.method647((byte) 34);
                            if(class40_sub5_sub14_sub1 == null) {
                                if(Class40_Sub13.aBoolean2177)
                                    bool = false;
                            } else {
                                RSString class1 = widget.disabledText;
                                int i_21_;
                                if(ItemDefinition.method746(widget)) {
                                    i_21_ = widget.alternateTextColor;
                                    if(Class29.method371(8247, arg0, i) && widget.alternateHoveredTextColor != 0)
                                        i_21_ = widget.alternateHoveredTextColor;
                                    if(widget.alternateText.length() > 0)
                                        class1 = (widget.alternateText);
                                } else {
                                    i_21_ = widget.textColor;
                                    if(Class29.method371(8247, arg0, i) && (widget.hoveredTextColor != 0))
                                        i_21_ = widget.hoveredTextColor;
                                }
                                if(widget.isIf3 && (widget.anInt2718 != -1)) {
                                    ItemDefinition class40_sub5_sub16 = (ItemDefinition.forId(widget.anInt2718, 10));
                                    class1 = class40_sub5_sub16.name;
                                    if(class1 == null)
                                        class1 = RSApplet.aClass1_34;
                                    if(class40_sub5_sub16.stackable == 1 || widget.anInt2734 != 1)
                                        class1 = (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{class1, Class29.aClass1_674, (Class45.method903((widget.anInt2734), (byte) -109))})));
                                }
                                if(widget.actionType == 6 && (CacheIndex_Sub1.anInt1819 == widget.id)) {
                                    i_21_ = widget.textColor;
                                    class1 = PacketBuffer.str_Please_Wait;
                                }
                                if(Rasterizer.width == 479) {
                                    if(i_21_ == 16776960)
                                        i_21_ = 255;
                                    if(i_21_ == 49152)
                                        i_21_ = 16777215;
                                }
                                class1 = (SceneTile.method532((byte) 20, widget, class1));
                                class40_sub5_sub14_sub1.drawText(class1, i_0_, i_1_, widget.originalWidth, widget.originalHeight, i_21_, widget.textShadowed, widget.xTextAlignment, widget.yTextAlignment, widget.lineHeight);
                            }
                        } else if(widget.type == 5) {
                            if(widget.isIf3) {
                                int i_22_ = 0;
                                int i_23_ = 0;
                                ImageRGB class40_sub5_sub14_sub4;
                                if(widget.anInt2718 == -1)
                                    class40_sub5_sub14_sub4 = widget.method643(127, false);
                                else {
                                    class40_sub5_sub14_sub4 = (Class40_Sub13.method876(99, widget.anInt2734, widget.anInt2718, 0));
                                    i_22_ = (class40_sub5_sub14_sub4.maxWidth);
                                    i_23_ = (class40_sub5_sub14_sub4.maxHeight);
                                    class40_sub5_sub14_sub4.maxHeight = 32;
                                    class40_sub5_sub14_sub4.maxWidth = 32;
                                }
                                if(class40_sub5_sub14_sub4 != null) {
                                    int i_24_ = (class40_sub5_sub14_sub4.image_height);
                                    int i_25_ = (class40_sub5_sub14_sub4.image_width);
                                    if(widget.aBoolean2641) {
                                        int[] is = new int[4];
                                        Rasterizer.method661(is);
                                        int i_27_ = i_0_;
                                        if((is[0] > i_27_))
                                            i_27_ = is[0];
                                        int i_28_ = i_1_;
                                        if((is[1] > i_28_))
                                            i_28_ = is[1];
                                        int i_29_ = (widget.originalWidth + i_0_);
                                        if((is[2] < i_29_))
                                            i_29_ = is[2];
                                        int i_30_ = (widget.originalHeight + i_1_);
                                        if(i_30_ > is[3])
                                            i_30_ = is[3];
                                        Rasterizer.setCoordinates(i_27_, i_28_, i_30_, i_29_);
                                        int i_31_ = (widget.originalWidth - (1 + -i_25_)) / i_25_;
                                        int i_32_ = (widget.originalHeight - (1 + -i_24_)) / i_24_;
                                        for(int i_33_ = 0; i_31_ > i_33_; i_33_++) {
                                            for(int i_34_ = 0; ((i_32_ > i_34_)); i_34_++) {
                                                if((widget.anInt2751) == 0) {
                                                    if(i_2_ == 0)
                                                        class40_sub5_sub14_sub4.drawImage((i_33_ * i_25_ + i_0_), (i_34_ * i_24_ + i_1_));
                                                    else
                                                        class40_sub5_sub14_sub4.method728((i_0_ + (i_33_ * i_25_)), (i_1_ + (i_24_ * i_34_)), (-(i_2_ & 0xff) + 256));
                                                } else
                                                    class40_sub5_sub14_sub4.method720((i_25_ / 2 + (i_33_ * i_25_ + i_0_)), (i_24_ / 2 + (i_1_ + (i_24_ * i_34_))), (widget.anInt2751), 4096);
                                            }
                                        }
                                        Rasterizer.method657(is);
                                    } else {
                                        int i_26_ = 4096 * (widget.originalWidth) / i_25_;
                                        if(widget.anInt2751 == 0) {
                                            if(i_2_ == 0) {
                                                if(((widget.originalWidth) == i_25_) && ((widget.originalHeight) == i_24_))
                                                    class40_sub5_sub14_sub4.drawImage(i_0_, i_1_);
                                                else
                                                    class40_sub5_sub14_sub4.method732(i_0_, i_1_, (widget.originalWidth), (widget.originalHeight));
                                            } else
                                                class40_sub5_sub14_sub4.method716(i_0_, i_1_, (widget.originalWidth), (widget.originalHeight), 256 + -(0xff & i_2_));
                                        } else
                                            class40_sub5_sub14_sub4.method720((widget.originalWidth) / 2 + i_0_, (widget.originalHeight) / 2 + i_1_, (widget.anInt2751), i_26_);
                                    }
                                } else if(Class40_Sub13.aBoolean2177)
                                    bool = false;
                                if(widget.anInt2718 != -1) {
                                    if(widget.anInt2734 != 1 || i_22_ == 33) {
                                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.drawString((HashTable.method334((widget.anInt2734), -1)), i_0_ + 1, i_1_ + 10, 0);
                                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.drawString((HashTable.method334((widget.anInt2734), -1)), i_0_, 9 + i_1_, 16776960);
                                    }
                                    class40_sub5_sub14_sub4.maxWidth = i_22_;
                                    class40_sub5_sub14_sub4.maxHeight = i_23_;
                                }
                            } else {
                                ImageRGB class40_sub5_sub14_sub4 = (widget.method643(127, (ItemDefinition.method746(widget))));
                                if(class40_sub5_sub14_sub4 != null)
                                    class40_sub5_sub14_sub4.drawImage(i_0_, i_1_);
                                else if(Class40_Sub13.aBoolean2177)
                                    bool = false;
                            }
                        } else if(widget.type == 6) {
                            boolean bool_35_ = (ItemDefinition.method746(widget));
                            Object object = null;
                            int i_36_;
                            if(!bool_35_)
                                i_36_ = widget.animation;
                            else
                                i_36_ = widget.alternateAnimation;

                            Model model;
                            if(widget.modelType != 5) {
                                if(i_36_ == -1) {
                                    model = (widget.method646((byte) 46, null, -1, bool_35_, (Player.localPlayer.aClass30_3282)));
                                    if(model == null && Class40_Sub13.aBoolean2177)
                                        bool = false;
                                } else {
                                    AnimationSequence animationSequence = Class68_Sub1.method1050(i_36_, 2);
                                    model = (widget.method646((byte) 76, animationSequence, widget.anInt2654, bool_35_, (Player.localPlayer.aClass30_3282)));
                                    if(model == null && Class40_Sub13.aBoolean2177)
                                        bool = false;
                                }
                            } else if(widget.modelId != 0)
                                model = Player.localPlayer.getRotatedModel(92);
                            else
                                model = (Class45.aClass30_1082.getAnimatedModel(null, null, -1, -1, (byte) -88));
                            int i_37_ = widget.rotationX;
                            int i_38_ = widget.rotationY;
                            int i_39_ = widget.offsetY2d;
                            int i_40_ = widget.rotationZ;
                            int i_41_ = widget.offsetX2d;
                            int i_42_ = widget.modelZoom;
                            if(widget.anInt2718 != -1) {
                                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId((widget.anInt2718), 10);
                                if(class40_sub5_sub16 != null) {
                                    class40_sub5_sub16 = (class40_sub5_sub16.method743(widget.anInt2734));
                                    model = class40_sub5_sub16.asGroundStack(true, 1);
                                    i_38_ = class40_sub5_sub16.zan2d;
                                    i_39_ = class40_sub5_sub16.yOffset2d;
                                    i_41_ = class40_sub5_sub16.xOffset2d;
                                    i_37_ = class40_sub5_sub16.xan2d;
                                    i_42_ = class40_sub5_sub16.zoom2d;
                                    i_40_ = class40_sub5_sub16.yan2d;
                                    if(widget.originalWidth > 0)
                                        i_42_ = (32 * i_42_ / (widget.originalWidth));
                                }
                            }
                            Rasterizer3D.method710(i_0_ + widget.originalWidth / 2, widget.originalHeight / 2 + i_1_);

                            int i_43_ = (i_42_ * (Rasterizer3D.sinetable[i_37_]) >> 16);
                            int i_44_ = (i_42_ * (Rasterizer3D.cosinetable[i_37_]) >> 16);
                            if(model != null) {
                                if(widget.isIf3) {
                                    model.method799();
                                    if(widget.orthogonal)
                                        model.method801(0, i_40_, i_38_, i_37_, i_41_, (i_39_ + i_43_ + (model.modelHeight) / 2), i_44_ + i_39_, i_42_);
                                    else
                                        model.method812(0, i_40_, i_38_, i_37_, i_41_, (i_39_ + ((model.modelHeight) / 2 + i_43_)), i_44_ + i_39_);
                                } else
                                    model.method812(0, i_40_, 0, i_37_, 0, i_43_, i_44_);
                            }
                            Rasterizer3D.method702();
                        } else {
                            if(widget.type == 7) {
                                TypeFace class40_sub5_sub14_sub1 = widget.method647((byte) 34);
                                if(class40_sub5_sub14_sub1 == null) {
                                    if(Class40_Sub13.aBoolean2177)
                                        bool = false;
                                    continue;
                                }
                                int i_45_ = 0;
                                for(int i_46_ = 0; ((i_46_ < widget.originalHeight)); i_46_++) {
                                    for(int i_47_ = 0; (i_47_ < widget.originalWidth); i_47_++) {
                                        if((widget.items[i_45_]) > 0) {
                                            ItemDefinition class40_sub5_sub16 = (ItemDefinition.forId((-1 + (widget.items[i_45_])), 10));
                                            RSString class1 = (class40_sub5_sub16.name);
                                            if(class1 == null)
                                                class1 = (RSApplet.aClass1_34);
                                            if((class40_sub5_sub16.stackable) == 1 || (widget.itemAmounts[i_45_]) != 1)
                                                class1 = (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{class1, (Class29.aClass1_674), (Class45.method903((widget.itemAmounts[i_45_]), (byte) -105))})));
                                            int i_48_ = ((i_47_ * ((widget.itemSpritePadsX) + 115)) + i_0_);
                                            int i_49_ = ((i_46_ * ((widget.itemSpritePadsY) + 12)) + i_1_);
                                            if((widget.xTextAlignment) == 0)
                                                class40_sub5_sub14_sub1.drawShadowedString(class1, i_48_, i_49_, (widget.textColor), (widget.textShadowed));
                                            else if((widget.xTextAlignment) == 1)
                                                class40_sub5_sub14_sub1.method688(class1, (i_48_ + (widget.originalWidth) / 2), i_49_, (widget.textColor), (widget.textShadowed));
                                            else
                                                class40_sub5_sub14_sub1.method677(class1, (-1 + (widget.originalWidth) + i_48_), i_49_, (widget.textColor), (widget.textShadowed));
                                        }
                                        i_45_++;
                                    }
                                }
                            }
                            if(widget.type == 8 && Class37.method438(arg0, i, (byte) 52) && (RSString.anInt1711 == WallDecoration.anInt1257)) {
                                int i_50_ = 0;
                                int i_51_ = 0;
                                TypeFace class40_sub5_sub14_sub1 = (WallDecoration.fontNormal);
                                RSString class1 = widget.disabledText;
                                class1 = (SceneTile.method532((byte) 20, widget, class1));
                                while(class1.length() > 0) {
                                    int i_52_ = class1.contains((Class30.aClass1_686));
                                    RSString class1_53_;
                                    if(i_52_ == -1) {
                                        class1_53_ = class1;
                                        class1 = HuffmanEncoding.blank_string;
                                    } else {
                                        class1_53_ = class1.substring(0, i_52_);
                                        class1 = class1.substring(2 + i_52_);
                                    }
                                    int i_54_ = class40_sub5_sub14_sub1.getTextDisplayedWidth(class1_53_);
                                    i_51_ += (class40_sub5_sub14_sub1.characterDefaultHeight) + 1;
                                    if((i_50_ < i_54_))
                                        i_50_ = i_54_;
                                }
                                i_51_ += 7;
                                int i_55_ = 5 + (widget.originalHeight + i_1_);
                                if(i_55_ + i_51_ > arg5)
                                    i_55_ = arg5 + -i_51_;
                                i_50_ += 6;
                                int i_56_ = -5 + (widget.originalWidth + i_0_ - i_50_);
                                if((i_56_ < 5 + i_0_))
                                    i_56_ = 5 + i_0_;
                                if(i_50_ + i_56_ > arg6)
                                    i_56_ = -i_50_ + arg6;
                                Rasterizer.drawFilledRectangle(i_56_, i_55_, i_50_, i_51_, 16777120);
                                Rasterizer.drawUnfilledRectangle(i_56_, i_55_, i_50_, i_51_, 0);
                                class1 = widget.disabledText;
                                int i_57_ = (2 + (i_55_ + (class40_sub5_sub14_sub1.characterDefaultHeight)));
                                class1 = (SceneTile.method532((byte) 20, widget, class1));
                                while(class1.length() > 0) {
                                    int i_58_ = class1.contains((Class30.aClass1_686));
                                    RSString class1_59_;
                                    if(i_58_ == -1) {
                                        class1_59_ = class1;
                                        class1 = HuffmanEncoding.blank_string;
                                    } else {
                                        class1_59_ = class1.substring(0, i_58_);
                                        class1 = class1.substring(i_58_ + 2);
                                    }
                                    class40_sub5_sub14_sub1.drawShadowedString(class1_59_, i_56_ + 3, i_57_, 0, false);
                                    i_57_ += 1 + (class40_sub5_sub14_sub1.characterDefaultHeight);
                                }
                            }
                            if(widget.type == 9)
                                Rasterizer.drawDiagonalLine(i_0_, i_1_, widget.originalWidth + i_0_, widget.originalHeight + i_1_, widget.textColor);
                        }
                    }
                }
            }
        }
        return bool;
    }

    public static void method37(CacheIndex_Sub1 arg0, byte arg1, int arg2) {
        if(arg1 != 98)
            aClass1_1777 = null;
        if(Class48.aClass40_Sub1_1132 == null) {
            HashTable.method327(true, null, 255, 255, (byte) 0, 0, (byte) 90);
            Class24.aClass6_Sub1Array580[arg2] = arg0;
        } else {
            Class48.aClass40_Sub1_1132.currentPosition = 5 + arg2 * 4;
            int i = Class48.aClass40_Sub1_1132.getIntBE();
            arg0.method200(i, 99);
        }
    }

    public static void renderFlames(int arg0) {
        if(Class40_Sub5_Sub6.anInt2452 <= 0) {
            if(IdentityKit.anInt2613 > 0) {
                for(int i = 0; i < 256; i++) {
                    if(IdentityKit.anInt2613 > 768)
                        Class42.anIntArray1013[i] = (UnderlayDefinition.method614((byte) -112, Class51.anIntArray1198[i], Class40_Sub5_Sub17_Sub6.anIntArray3248[i], -IdentityKit.anInt2613 + 1024));
                    else if(IdentityKit.anInt2613 > 256)
                        Class42.anIntArray1013[i] = Class40_Sub5_Sub17_Sub6.anIntArray3248[i];
                    else
                        Class42.anIntArray1013[i] = (UnderlayDefinition.method614((byte) -124, Class40_Sub5_Sub17_Sub6.anIntArray3248[i], Class51.anIntArray1198[i], -IdentityKit.anInt2613 + 256));
                }
            } else {
                for(int i = 0; i < 256; i++)
                    Class42.anIntArray1013[i] = Class51.anIntArray1198[i];
            }
        } else {
            for(int i = 0; i < 256; i++) {
                if(Class40_Sub5_Sub6.anInt2452 <= 768) {
                    if(Class40_Sub5_Sub6.anInt2452 > 256)
                        Class42.anIntArray1013[i] = Renderable.anIntArray2865[i];
                    else
                        Class42.anIntArray1013[i] = (UnderlayDefinition.method614((byte) 93, Renderable.anIntArray2865[i], Class51.anIntArray1198[i], -Class40_Sub5_Sub6.anInt2452 + 256));
                } else
                    Class42.anIntArray1013[i] = (UnderlayDefinition.method614((byte) 81, Class51.anIntArray1198[i], Renderable.anIntArray2865[i], -Class40_Sub5_Sub6.anInt2452 + 1024));
            }
        }
        int i = 256;
        for(int i_60_ = 0; i_60_ < 33920; i_60_++)
            Class8.aClass68_298.anIntArray1621[i_60_] = (Class39.aClass40_Sub5_Sub14_Sub4_918.pixels[i_60_]);
        int i_61_ = 0;
        int i_62_ = 1152;
        for(int i_63_ = 1; i - 1 > i_63_; i_63_++) {
            int i_64_ = (-i_63_ + i) * Class17.anIntArray466[i_63_] / i;
            int i_65_ = i_64_ + 22;
            if(i_65_ < 0)
                i_65_ = 0;
            i_61_ += i_65_;
            for(int i_66_ = i_65_; i_66_ < 128; i_66_++) {
                int i_67_ = Class4.anIntArray178[i_61_++];
                if(i_67_ != 0) {
                    int i_68_ = -i_67_ + 256;
                    int i_69_ = i_67_;
                    i_67_ = Class42.anIntArray1013[i_67_];
                    int i_70_ = Class8.aClass68_298.anIntArray1621[i_62_];
                    Class8.aClass68_298.anIntArray1621[i_62_++] = ((HuffmanEncoding.method1021(-16711936, (HuffmanEncoding.method1021(i_67_, 16711935) * i_69_ + (i_68_ * HuffmanEncoding.method1021(i_70_, 16711935))))) + (HuffmanEncoding.method1021((HuffmanEncoding.method1021(65280, i_70_) * i_68_ + i_69_ * HuffmanEncoding.method1021(65280, i_67_)), 16711680))) >> 8;
                } else
                    i_62_++;
            }
            i_62_ += i_65_;
        }
        i_62_ = 1176;
        i_61_ = arg0;
        for(int i_71_ = 0; i_71_ < 33920; i_71_++)
            GameObject.aClass68_3042.anIntArray1621[i_71_] = (SceneTile.aClass40_Sub5_Sub14_Sub4_2043.pixels[i_71_]);
        for(int i_72_ = 1; (i_72_ < -1 + i); i_72_++) {
            int i_73_ = (-i_72_ + i) * Class17.anIntArray466[i_72_] / i;
            int i_74_ = 103 + -i_73_;
            i_62_ += i_73_;
            for(int i_75_ = 0; i_75_ < i_74_; i_75_++) {
                int i_76_ = Class4.anIntArray178[i_61_++];
                if(i_76_ != 0) {
                    int i_77_ = i_76_;
                    int i_78_ = (GameObject.aClass68_3042.anIntArray1621[i_62_]);
                    int i_79_ = 256 + -i_76_;
                    i_76_ = Class42.anIntArray1013[i_76_];
                    GameObject.aClass68_3042.anIntArray1621[i_62_++] = ((HuffmanEncoding.method1021((i_77_ * HuffmanEncoding.method1021(65280, i_76_) + i_79_ * HuffmanEncoding.method1021(65280, i_78_)), 16711680)) + (HuffmanEncoding.method1021((i_79_ * HuffmanEncoding.method1021(16711935, i_78_) + (HuffmanEncoding.method1021(16711935, i_76_) * i_77_)), -16711936))) >> 8;
                } else
                    i_62_++;
            }
            i_62_ += 128 - (i_74_ + i_73_);
            i_61_ += -i_74_ + 128;
        }
    }

    public static void main(String[] arg0) {
        try {
            if(arg0.length != 6)
                Class37.method432((byte) 37);
            Class13.worldid = Integer.parseInt(arg0[0]);
            if(!arg0[1].equals("live")) {
                if(arg0[1].equals("office"))
                    Class44.modewhere = 1;
                else if(arg0[1].equals("local"))
                    Class44.modewhere = 2;
                else
                    Class37.method432((byte) 118);
            } else
                Class44.modewhere = 0;
            if(arg0[2].equals("live"))
                Class44.modewhat = 0;
            else if(!arg0[2].equals("rc")) {
                if(arg0[2].equals("wip"))
                    Class44.modewhat = 2;
                else
                    Class37.method432((byte) 34);
            } else
                Class44.modewhat = 1;
            if(arg0[3].equals("lowmem"))
                Class59.method983(120);
            else if(arg0[3].equals("highmem"))
                Class8.method210();
            else
                Class37.method432((byte) 121);
            if(!arg0[4].equals("free")) {
                if(arg0[4].equals("members"))
                    Class22.aBoolean541 = true;
                else
                    Class37.method432((byte) 93);
            } else
                Class22.aBoolean541 = false;
            if(arg0[5].equals("english")) {
                Class34.anInt848 = 0;
            } else if(arg0[5].equals("german")) {
                Class55.setGerman();
                Class34.anInt848 = 1;
            } else {
                Class37.method432((byte) 106);
            }
            Main main = new Main();
            main.openClientApplet("runescape", 13, 503, 32 + Class44.modewhat, InetAddress.getLocalHost(), 435, 765);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void method41() {
        aClass1_1762 = null;
        aClass1_1781 = null;
        aClass1Array1778 = null;
        aClass1_1763 = null;
        aClass1_1777 = null;
        aClass1_1788 = null;
        aClass1_1761 = null;
        aClass1_1757 = null;
    }

    public static int method42(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        arg5 &= 0x3;
        if((arg0 & arg1) == 1) {
            int i = arg2;
            arg2 = arg4;
            arg4 = i;
        }
        if(arg5 == 0)
            return arg3;
        if(arg5 == 1)
            return arg6;
        if(arg5 == 2)
            return 7 - (arg3 + arg2) + 1;
        return 7 + (-arg6 + 1) + -arg4;
    }

    public static void method43(CacheIndex arg0, boolean arg1) {
        if(arg1) {
            Class64.aCacheIndex_1521 = arg0;
            Class59.anInt1383 = Class64.aCacheIndex_1521.method190(16, (byte) 24);
        }
    }

    public static void method44(int arg0) {
        Class51.aLong1203 = 0L;
        Class12.mouseCapturer.coord = 0;
        Class22_Sub2.duplicateClickCount = 0;
        Wall.anInt335 = 0;
        Class42.anInt994 = 0;
        SubNode.anInt2088 = 0;
        Class52.anInt1211 = 0;
        VarbitDefinition.anInt2363 = 0;
        Class40_Sub13.anInt2184 = 0;
        Class60.anInt1418 = 0;
        OverlayDefinition.anInt2348 = 0;
        Class4.anInt184 = 0;
        Class42.anInt992 = 0;
        Class13.anInt413 = 0;
        RSCanvas.anInt58 = 0;
        Class60.anInt1412 = 0;
        Class59.anInt1381 = 0;
        Renderable.anInt2868 = 0;
        Class43.anInt1018 = 0;
        Class13.anInt400 = 0;
        UnderlayDefinition.anInt2580 = 0;
        Class37.anInt866 = 0;
        Class40_Sub3.anInt2034 = 0;
        Class56.anInt1319 = 0;
        OverlayDefinition.anInt2341 = 0;
        OverlayDefinition.anInt2331 = 0;
        VarbitDefinition.anInt2365 = 0;
        Class35.anInt1723 = 0;
        Class40_Sub13.anInt2169 = 0;
        SubNode.anInt2085 = 0;
        Class38.anInt891 = 0;
        Wall.anInt339 = 0;
        Class32.anInt765 = 0;
        SceneTile.anInt2041 = 0;
        Class52.anInt1227 = 0;
        CacheIndex_Sub1.anInt1793 = 0;
        Class40_Sub5_Sub17_Sub3.anInt3061 = 0;
        Class57.anInt1330 = 0;
        FloorDecoration.anInt599 = 0;
        Class29.anInt677 = 0;
        Class40_Sub6.anInt2115 = 0;
        FloorDecoration.anInt596 = 0;
        Class37.anInt859 = 0;
        Actor.anInt3128 = 0;
        Class34.anInt815 = 0;
        Class40_Sub5_Sub17_Sub3.anInt3053 = 0;
        Class40_Sub7.anInt2126 = 0;
        Class59.anInt1384 = 0;
        Class40_Sub5_Sub17_Sub1.anInt2986 = 0;
        WallDecoration.anInt1248 = 0;
        Class40_Sub5_Sub11.anInt2632 = 0;
        WallDecoration.anInt1250 = 0;
        Class40_Sub6.anInt2100 = 0;
        Renderable.anInt2863 = 0;
        OverlayDefinition.anInt2339 = 0;
        Class22_Sub1.anInt1839 = 0;
        Class65.anInt1532 = 0;
        CacheIndex_Sub1.anInt1808 = 0;
        Class40_Sub5_Sub17_Sub1.anInt2979 = 0;
        Class35.anInt1722 = 0;
        FloorDecoration.anInt598 = 0;
        OverlayDefinition.anInt2326 = 0;
        Class60.anInt1405 = 0;
        Class22_Sub1.anInt1840 = 0;
        Class40_Sub5_Sub11.anInt2619 = 0;
        Class37.anInt864 = 0;
        VarbitDefinition.anInt2362 = 0;
        Class22_Sub1.anInt1862 = 0;
        Class40_Sub5_Sub17_Sub6.anInt3232 = 0;
        Class22_Sub1.anInt1859 = 0;
        Class40_Sub3.anInt2029 = 0;
        Class40_Sub13.anInt2170 = 0;
        Class22_Sub1.anInt1843 = 0;
        Class52.anInt1236 = 0;
        Class13.anInt410 = 0;
        Actor.anInt3106 = 0;
        Node.anInt927 = 0;
        Class24.anInt579 = 0;
        Actor.anInt3108 = 0;
        OverlayDefinition.anInt2316 = 0;
        CacheIndex_Sub1.anInt1815 = 0;
        Class40_Sub5_Sub17_Sub3.anInt3064 = 0;
        Class44.anInt1045 = 0;
        Class40_Sub2.anInt2006 = 0;
        Class32.anInt744 = 0;
        Class59.anInt1382 = 0;
        Class65.anInt1534 = 0;
        Wall.anInt345 = 0;
        FloorDecoration.anInt592 = 0;
        ISAAC.anInt514 = 0;
        Class24.anInt586 = 0;
        Class40_Sub3.anInt2022 = 0;
        Class42.anInt999 = 0;
        Node.anInt971 = 0;
        Class52.anInt1237 = 0;
        Class44.anInt1050 = 0;
        Class42.anInt1007 = 0;
        Actor.anInt3146 = 0;
        Class43.anInt1023 = 0;
        Class56.anInt1310 = 0;
        Class13.anInt415 = 0;
        Class24.anInt585 = 0;
        Class40_Sub6.anInt2108 = 0;
        CacheIndex_Sub1.anInt1817 = 0;
        Landscape.anInt1177 = 0;
        Class22.anInt536 = 0;
        Class40_Sub13.anInt2180 = 0;
        Class32.anInt754 = 0;
        Actor.anInt3147 = 0;
        Actor.anInt3076 = 0;
        Class22_Sub1.anInt1854 = 0;
        Class52.anInt1239 = 0;
        RSCanvas.anInt56 = 0;
        Class49.anInt1142 = 0;
        Class37.anInt862 = 0;
        Class59.anInt1380 = 0;
        Class51.anInt1192 = 0;
        RSCanvas.anInt52 = 0;
        Class40_Sub13.anInt2182 = 0;
        Renderable.anInt2867 = 0;
        ISAAC.anInt520 = 0;
        Class40_Sub5_Sub17_Sub1.anInt2994 = 0;
        Class40_Sub2.anInt1999 = 0;
        Class40_Sub5_Sub17_Sub1.anInt3007 = 0;
        Actor.anInt3133 = 0;
        VarbitDefinition.anInt2369 = 0;
        ISAAC.anInt503 = 0;
        Class34.anInt806 = 0;
        Class39.anInt916 = 0;
        Class34.anInt838 = 0;
        Class40_Sub5_Sub13.anInt2756 = 0;
        Class22_Sub1.anInt1853 = 0;
        Node.anInt935 = 0;
        Class37.anInt868 = 0;
        Class35.anInt1724 = 0;
        Class60.anInt1414 = 0;
        Class56.anInt1326 = 0;
        VarbitDefinition.anInt2371 = 0;
        Class44.anInt1036 = 0;
        Class44.anInt1044 = 0;
        Class43.anInt1016 = 0;
        Class40_Sub5_Sub17_Sub1.anInt2959 = 0;
        Class40_Sub5_Sub17_Sub1.anInt2956 = 0;
        Renderable.anInt2859 = 0;
        Class56.anInt1322 = 0;
        Class4.anInt187 = 0;
        Class22.anInt531 = 0;
        CacheIndex.anInt211 = 0;
        CacheIndex.anInt263 = 0;
        Class37.anInt870 = 0;
        Class60.anInt1400 = 0;
        Class40_Sub2.anInt1992 = 0;
        Class37.anInt863 = 0;
        FloorDecoration.anInt597 = 0;
        Renderable.anInt2855 = 0;
        Class40_Sub7.anInt2122 = 0;
        Actor.anInt3103 = 0;
        Class60.anInt1410 = 0;
        Class40_Sub13.anInt2173 = 0;
        Class51.anInt1191 = 0;
        Class40_Sub5_Sub17_Sub3.anInt3052 = 0;
        Class42.anInt991 = 0;
        Landscape.anInt1182 = 0;
        Class40_Sub5_Sub15.anInt2783 = 0;
        Class13.anInt409 = 0;
        Class29.anInt669 = 0;
        Class22.anInt543 = 0;
        Class13.anInt401 = 0;
        Class22.anInt539 = 0;
        Class34.anInt821 = 0;
        UnderlayDefinition.anInt2569 = 0;
        Class40_Sub5_Sub13.anInt2759 = 0;
        Class22.anInt540 = 0;
        CacheIndex.anInt234 = 0;
        CacheIndex_Sub1.anInt1804 = 0;
        CacheIndex_Sub1.anInt1792 = 0;
        Class35.anInt1741 = 0;
        Node.anInt961 = 0;
        Class13.anInt408 = 0;
        Actor.anInt3084 = 0;
        Class22_Sub1.anInt1842 = 0;
        Node.anInt962 = 0;
        Class52.anInt1224 = 0;
        Class52.anInt1240 = 0;
        Landscape.anInt1179 = 0;
        Class40_Sub5_Sub17_Sub1.anInt2970 = 0;
        SubNode.anInt2089 = 0;
        Class29.anInt675 = 0;
        Class60.anInt1404 = 0;
        Actor.anInt3142 = 0;
        Class56.anInt1327 = 0;
        Landscape.anInt1159 = 0;
        Actor.anInt3121 = 0;
        Class24.anInt584 = 0;
        ISAAC.anInt500 = 0;
        Class40_Sub5_Sub17_Sub1.anInt3008 = 0;
        VarbitDefinition.anInt2355 = 0;
        Class35.anInt1751 = 0;
        Class44.anInt1037 = 0;
        SubNode.anInt2094 = 0;
        Class52.anInt1212 = 0;
        Class40_Sub5_Sub17_Sub1.anInt3005 = 0;
        SceneTile.anInt2040 = 0;
        CacheIndex_Sub1.anInt1818 = 0;
        Class22_Sub1.anInt1850 = 0;
        CacheIndex.anInt245 = 0;
        CacheIndex.anInt240 = 0;
        Class44.anInt1029 = 0;
        Class40_Sub5_Sub13.anInt2761 = 0;
        Class60.anInt1406 = 0;
        Class22_Sub1.anInt1837 = 0;
        CacheIndex.anInt222 = 0;
        Class24.anInt582 = 0;
        Landscape.anInt1165 = 0;
        SceneTile.anInt2052 = 0;
        Class40_Sub5_Sub17_Sub6.anInt3234 = 0;
        Class40_Sub5_Sub17_Sub3.anInt3070 = 0;
        Class34.anInt836 = 0;
        Class40_Sub2.anInt2004 = 0;
        Class65.anInt1539 = 0;
        Class35.anInt1739 = 0;
        WallDecoration.anInt1245 = 0;
        CacheIndex.anInt237 = 0;
        CollisionMap.anInt158 = 0;
        Class40_Sub5_Sub11.anInt2624 = 0;
        FloorDecoration.anInt604 = 0;
        Class40_Sub5_Sub17_Sub1.anInt2978 = 0;
        Landscape.anInt1164 = 0;
        Class34.anInt800 = 0;
        Class38.anInt897 = 0;
        Class43.anInt1015 = 0;
        CacheIndex_Sub1.anInt1805 = 0;
        OverlayDefinition.anInt2347 = 0;
        Class56.anInt1325 = 0;
        VarbitDefinition.anInt2353 = 0;
        Actor.anInt3085 = 0;
        Class40_Sub5_Sub13.anInt2755 = 0;
        Class40_Sub2.anInt1998 = 0;
        Class40_Sub5_Sub17_Sub6.anInt3241 = 0;
        CacheIndex_Sub1.anInt1795 = 0;
        Class22_Sub1.anInt1869 = 0;
        Class35.anInt1721 = 0;
        CacheIndex.anInt235 = 0;
        RSCanvas.anInt50 = 0;
        Class51.anInt1189 = 0;
        Class40_Sub5_Sub15.anInt2789 = 0;
        SceneTile.anInt2056 = 0;
        Class40_Sub5_Sub17_Sub6.anInt3252 = 0;
        Class34.anInt807 = 0;
        Class37.anInt861 = 0;
        Class34.anInt803 = 0;
        SubNode.anInt2096 = 0;
        Class56.anInt1317 = 0;
        Class40_Sub5_Sub15.anInt2785 = 0;
        Class37.anInt865 = 0;
        Class42.anInt1009 = 0;
        Class40_Sub5_Sub17_Sub3.anInt3057 = 0;
        Class32.anInt753 = 0;
        InteractiveObject.anInt467 = 0;
        Class56.anInt1328 = 0;
        Class4.anInt186 = 0;
        SubNode.anInt2092 = 0;
        CacheIndex_Sub1.anInt1794 = 0;
        Node.anInt928 = 0;
        Class13.anInt416 = 0;
        CacheIndex.anInt242 = 0;
        Class56.anInt1312 = 0;
        ISAAC.anInt499 = 0;
        Class40_Sub5_Sub17_Sub6.anInt3251 = 0;
        Class40_Sub5_Sub11.anInt2618 = 0;
        OverlayDefinition.anInt2329 = 0;
        Node.anInt970 = 0;
        CacheIndex_Sub1.anInt1809 = 0;
        Class24.anInt576 = 0;
        OverlayDefinition.anInt2343 = 0;
        WallDecoration.anInt1256 = 0;
        CacheIndex.anInt230 = 0;
        VarbitDefinition.anInt2360 = 0;
        Class42.anInt1004 = 0;
        Class35.anInt1742 = 0;
        Class35.anInt1729 = 0;
        UnderlayDefinition.anInt2572 = 0;
        CacheIndex_Sub1.anInt1803 = 0;
        Class51.anInt1190 = 0;
        Class29.anInt679 = 0;
        Class56.anInt1311 = 0;
        ISAAC.anInt501 = 0;
        SceneTile.anInt2045 = 0;
        Class29.anInt672 = 0;
        Class60.anInt1403 = 0;
        Class35.anInt1719 = 0;
        OverlayDefinition.anInt2317 = 0;
        Class51.anInt1193 = 0;
        ISAAC.anInt507 = 0;
        WallDecoration.anInt1258 = 0;
        Class40_Sub2.anInt2009 = 0;
        Class13.anInt407 = 0;
        Class40_Sub5_Sub17_Sub3.anInt3063 = 0;
        Class44.anInt1031 = arg0;
        ISAAC.anInt504 = 0;
        Class35.aBoolean1735 = true;
        HashTable.aBoolean571 = true;
        SubNode.method540(arg0 + 23721);
        Cache.anInt324 = -1;
        Class4.menuOpen = false;
        RSString.anInt1690 = -1;
        Class57.incomingPacket = -1;
        Class40_Sub5_Sub15.anInt2782 = 0;
        Class35.anInt1728 = 0;
        Player.anInt3288 = 0;
        Class32.packetBuffer.currentPosition = 0;
        Class32.anInt771 = 0;
        Class49.anInt1151 = -1;
        Cache.outgoingbuffer.currentPosition = 0;
        ActorDefinition.anInt2394 = 0;
        Class40_Sub5_Sub13.method650(true, 0);
        for(int i = 0; i < 100; i++)
            Actor.chatMessages[i] = null;
        Class8.anInt301 = 0;
        Class57.anInt1342 = -40 + (int) (80.0 * Math.random());
        Class48.anInt1126 = -55 + (int) (Math.random() * 110.0);
        VarbitDefinition.anInt2366 = 0;
        Class43.cameraYawOffset = (int) (Math.random() * 120.0) + -60;
        Buffer.anInt1985 = -1;
        GameObjectDefinition.anInt2558 = 0;
        PacketBuffer.currentSound = 0;
        anInt1773 = 0;
        GroundItemTile.cameraHorizontal = 0x7ff & -10 + (int) (20.0 * Math.random());
        Class51.mapZoomOffset = -20 + (int) (Math.random() * 30.0);
        Class27.anInt658 = 0;
        Buffer.anInt1976 = -50 + (int) (Math.random() * 100.0);
        Class60.anInt1407 = 0;
        Class55.anInt1304 = 0;
        for(int i = 0; i < 2048; i++) {
            Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i] = null;
            Class22.aClass40_Sub1Array534[i] = null;
        }
        for(int i = 0; i < 32768; i++)
            CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i] = null;
        Player.localPlayer = Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[2047] = new Player();
        Class43.aClass45_1022.method906(0);
        Class57.aClass45_1332.method906(0);
        for(int i = 0; i < 4; i++) {
            for(int i_82_ = 0; i_82_ < 104; i_82_++) {
                for(int i_83_ = 0; i_83_ < 104; i_83_++)
                    Wall.aClass45ArrayArrayArray357[i][i_82_][i_83_] = null;
            }
        }
        Class45.aClass45_1064 = new Class45();
        Class40_Sub5_Sub17_Sub3.friendsCount = 0;
        Class12.friendListStatus = 0;
        Class55.method958(Class48.anInt1138, arg0 ^ ~0x378d);
        Class48.anInt1138 = -1;
        Class55.method958(Class43.openChatboxWidgetId, -14222);
        Class43.openChatboxWidgetId = -1;
        Class55.method958(HuffmanEncoding.openScreenWidgetId, -14222);
        HuffmanEncoding.openScreenWidgetId = -1;
        Class55.method958(ActorDefinition.openFullScreenWidgetId, arg0 + -14222);
        ActorDefinition.openFullScreenWidgetId = -1;
        Class55.method958(UnderlayDefinition.openSecondaryWidgetId, -14222);
        UnderlayDefinition.openSecondaryWidgetId = -1;
        Class55.method958(Class29.tabAreaOverlayWidgetId, arg0 ^ ~0x378d);
        Class29.tabAreaOverlayWidgetId = -1;
        Class55.method958(GroundItemTile.anInt1376, -14222);
        Class40_Sub5_Sub15.inputType = 0;
        InteractiveObject.messagePromptRaised = false;
        Class4.menuOpen = false;
        GroundItemTile.anInt1376 = -1;
        RSApplet.aClass1_8 = null;
        CacheIndex_Sub1.anInt1819 = -1;
        Class51.anInt1205 = -1;
        Class40_Sub6.anInt2118 = 0;
        Class5.currentTabId = 3;
        Class45.aClass30_1082.method380(null, false, 7, new int[5], -1);
        for(int i = 0; i < 5; i++) {
            aClass1Array1778[i] = null;
            Class13.aBooleanArray414[i] = false;
        }
        ISAAC.aBoolean519 = true;
    }

    public void method35(int arg1) {
        if(Wall.anInt350 != OverlayDefinition.anInt2340)
            Wall.anInt350 = OverlayDefinition.anInt2340;
        else
            Wall.anInt350 = CollisionMap.anInt172;
        Class29.aClass64_676 = null;
        Class68.aSignlinkNode_1632 = null;
        Class8.anInt292++;
        Class8.anInt290 = 0;
        if(Class8.anInt292 < 2 || arg1 != 7 && arg1 != 9) {
            if(Class8.anInt292 < 2 || arg1 != 6) {
                if(Class8.anInt292 >= 4) {
                    if(Class51.anInt1197 <= 5) {
                        this.openErrorPage((byte) 104, "js5connect");
                        Class51.anInt1197 = 1000;
                    } else
                        ISAAC.anInt509 = 3000;
                }
            } else {
                this.openErrorPage((byte) 86, "js5connect_outofdate");
                Class51.anInt1197 = 1000;
            }
        } else if(Class51.anInt1197 > 5)
            ISAAC.anInt509 = 3000;
        else {
            this.openErrorPage((byte) 122, "js5connect_full");
            Class51.anInt1197 = 1000;
        }
    }

    public void method23(int arg0) {
        Node.pulseCycle++;
        method39(arg0 + 23636);
        Class13.method242((byte) -91);
        if(arg0 != -22636)
            method43(null, false);
        Class33.method413((byte) -116);
        RSRuntimeException.method1054((byte) 125);
        Widget.method639(122);
        Class64.method1015(-656);
        if(Class51.anInt1197 == 0) {
            Class40_Sub3.method530(arg0 + 22736);
            Class60.method992(75);
        } else if(Class51.anInt1197 == 5) {
            Class40_Sub3.method530(100);
            Class60.method992(75);
        } else if(Class51.anInt1197 != 10) {
            if(Class51.anInt1197 == 20) {
                Class60.method993(-103);
                SpotAnimDefinition.method552(true);
            } else if(Class51.anInt1197 == 25)
                Landscape.method933(-95);
        } else
            Class60.method993(-104);
        if(Class51.anInt1197 == 30)
            Npc.method796((byte) 77);
        else if(Class51.anInt1197 == 35)
            Npc.method796((byte) 98);
        else if(Class51.anInt1197 == 40)
            SpotAnimDefinition.method552(true);
    }

    public void method39(int arg0) {
        if(arg0 != Class51.anInt1197) {
            boolean bool = FloorDecoration.method346((byte) 48);
            if(!bool)
                method40(arg0 ^ 0x3ed);
        }
    }

    public void method34(int arg0) { // TODO: Might be Startup
        if(Class67.aBoolean1575) {
            Class22_Sub1.method311((byte) -80, GameFrame.aCanvas1469);
            Class55.method965(32, GameFrame.aCanvas1469);
            this.setCanvas((byte) 86);
            Widget.method642(GameFrame.aCanvas1469, -10);
            RSRuntimeException.method1056(GameFrame.aCanvas1469, (byte) 33);
        }
        if(Class51.anInt1197 == 0)
            GameObject.drawLoadingText(Class67.anInt1607, null, Class22_Sub2.currentLoadingText);
        else if(Class51.anInt1197 != 5) {
            if(Class51.anInt1197 != 10) {
                if(Class51.anInt1197 != 20) {
                    if(Class51.anInt1197 == 25) {
                        if(Class68.anInt1634 == 1) {
                            if(Class37.anInt874 > PacketBuffer.anInt2231)
                                PacketBuffer.anInt2231 = Class37.anInt874;
                            int i = ((-Class37.anInt874 + PacketBuffer.anInt2231) * 50 / PacketBuffer.anInt2231);
                            Class51.method940(0, Class67.aClass1_1585, true, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{CollisionMap.aClass1_170, HashTable.method334(i, -1), Class30.aClass1_698})));
                        } else if(Class68.anInt1634 == 2) {
                            if(IdentityKit.anInt2591 > GameObject.anInt3048)
                                GameObject.anInt3048 = IdentityKit.anInt2591;
                            int i = ((50 * (-IdentityKit.anInt2591 + GameObject.anInt3048) / GameObject.anInt3048) + 50);
                            Class51.method940(0, Class67.aClass1_1585, true, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{CollisionMap.aClass1_170, HashTable.method334(i, -1), Class30.aClass1_698})));
                        } else
                            Class51.method940(0, Class67.aClass1_1585, false, null);
                    } else if(Class51.anInt1197 != 30) {
                        if(Class51.anInt1197 != 35) {
                            if(Class51.anInt1197 == 40)
                                Class51.method940(0, (Npc.aClass1_3305), false, Actor.aClass1_3159);
                        } else
                            Class5.method164(0);
                    } else
                        Class27.method365(-20197);
                } else
                    WallDecoration.method951(-19010, (Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246), (Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236));
            } else
                WallDecoration.method951(-19010, (Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246), (Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236));
        } else
            WallDecoration.method951(-19010, (Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246), (Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236));
        Npc.anInt3294 = 0;
        int i = -22 / ((arg0 - 6) / 50);
    }

    public void method40(int arg0) {
        if(arg0 != 5)
            aClass1_1781 = null;
        if(Class34.anInt813 >= 4) {
            this.openErrorPage((byte) 120, "js5crc");
            Class51.anInt1197 = 1000;
        } else {
            if(Class40_Sub5_Sub1.anInt2278 >= 4) {
                if(Class51.anInt1197 > 5) {
                    Class40_Sub5_Sub1.anInt2278 = 3;
                    ISAAC.anInt509 = 3000;
                } else {
                    this.openErrorPage((byte) 58, "js5io");
                    Class51.anInt1197 = 1000;
                    return;
                }
            }
            if(ISAAC.anInt509-- <= 0) {
                do {
                    try {
                        if(Class8.anInt290 == 0) {
                            Class68.aSignlinkNode_1632 = ISAAC.aClass31_521.method395(arg0 ^ 0x6, Wall.anInt350);
                            Class8.anInt290++;
                        }
                        if(Class8.anInt290 == 1) {
                            if(Class68.aSignlinkNode_1632.anInt434 == 2) {
                                method35(-1);
                                break;
                            }
                            if(Class68.aSignlinkNode_1632.anInt434 == 1)
                                Class8.anInt290++;
                        }
                        if(Class8.anInt290 == 2) {
                            Class29.aClass64_676 = new Class64((Socket) (Class68.aSignlinkNode_1632.value), ISAAC.aClass31_521);
                            Buffer class40_sub1 = new Buffer(5);
                            class40_sub1.putByte(15);
                            class40_sub1.putIntBE(435);
                            Class29.aClass64_676.method1010(5, (byte) -19, 0, (class40_sub1.buffer));
                            Class8.anInt290++;
                            Class22_Sub1.aLong1841 = System.currentTimeMillis();
                        }
                        if(Class8.anInt290 == 3) {
                            if(Class51.anInt1197 > 5 && Class29.aClass64_676.method1014(arg0 + -131) <= 0) {
                                if((System.currentTimeMillis() + -Class22_Sub1.aLong1841) > 30000L) {
                                    method35(-2);
                                    break;
                                }
                            } else {
                                int i = Class29.aClass64_676.method1016(112);
                                if(i != 0) {
                                    method35(i);
                                    break;
                                }
                                Class8.anInt290++;
                            }
                        }
                        if(Class8.anInt290 != 4)
                            break;
                        Class17.method273(Class29.aClass64_676, 105, Class51.anInt1197 > 20);
                        Class68.aSignlinkNode_1632 = null;
                        Class8.anInt290 = 0;
                        Class29.aClass64_676 = null;
                        Class8.anInt292 = 0;
                    } catch(java.io.IOException ioexception) {
                        method35(-3);
                        break;
                    }
                    break;
                } while(false);
            }
        }
    }

    public void method24(int arg0) {
        if(Class12.mouseCapturer != null)
            Class12.mouseCapturer.aBoolean913 = false;
        Class12.mouseCapturer = null;
        if(Class40_Sub6.aClass64_2098 != null) {
            Class40_Sub6.aClass64_2098.method1009(-100);
            Class40_Sub6.aClass64_2098 = null;
        }
        ItemDefinition.method744();
        Class13.method249(true);
        Class33.method407(false);
        Class60.method989(true);
        ActorDefinition.method567(arg0 ^ 0x1);
        Class52.method947(-1);
        do {
            try {
                if(SpotAnimDefinition.aClass67_2298 != null)
                    SpotAnimDefinition.aClass67_2298.method1036(841617512);
                if(arg0 != 0)
                    method31(false);
                if(Class40_Sub5_Sub6.aClass67Array2436 != null) {
                    for(int i = 0; i < Class40_Sub5_Sub6.aClass67Array2436.length; i++) {
                        if(Class40_Sub5_Sub6.aClass67Array2436[i] != null)
                            Class40_Sub5_Sub6.aClass67Array2436[i].method1036(arg0 ^ 0x322a1068);
                    }
                }
                if(Class30.aClass67_693 == null)
                    break;
                Class30.aClass67_693.method1036(841617512);
            } catch(java.io.IOException ioexception) {
                break;
            }
            break;
        } while(false);
    }

    public void init() {
        if(this.verifyHost(31)) {
            Class13.worldid = Integer.parseInt(this.getParameter("worldid"));
            Class44.modewhat = Integer.parseInt(this.getParameter("modewhat"));
            Class44.modewhere = Integer.parseInt(this.getParameter("modewhere"));
            String string = this.getParameter("lowmem");
            if(string != null && string.equals("1"))
                Class59.method983(-111);
            else
                Class8.method210();
            String string_80_ = this.getParameter("members");
            Class22.aBoolean541 = string_80_ != null && string_80_.equals("1");
            String string_81_ = this.getParameter("lang");
            if(string_81_ != null && string_81_.equals("1")) {
                Class55.setGerman();
                Class34.anInt848 = 1;
            }
            this.displayClientFrame((byte) 120, 435, 503, 765, Class44.modewhat + 32);
        }
    }

    public void method16(int arg0) {
        method41();
        RSString.method83((byte) 121);
        RSApplet.method18();
        Class38.method439((byte) 123);
        Class68.method1042(arg0 + -28063);
        Class39.method453((byte) -74);
        Buffer.method499();
        Class64.method1011(true);
        CacheIndex_Sub1.method203(arg0 ^ 0x6dc2);
        Class67.method1037(false);
        Class56.method967(78);
        Npc.method797(arg0 + -27855);
        PacketBuffer.method514(1);
        Scene.method114();
        CollisionMap.method152(-19156);
        Player.method794(false);
        Class45.method900(29690);
        Widget.method641(-92);
        Class48.method924((byte) 111);
        Class30.method376(arg0 + -14636);
        Actor.method788(87);
        Class40_Sub3.method529(-10);
        ActorDefinition.method581(-96);
        HashTable.method328(false);
        Node.method458((byte) 127);
        ISAAC.method282(true);
        Class49.method930(94);
        Cache.method234(arg0 ^ 0x6def);
        AnimationSequence.method589(arg0 ^ 0x6de9);
        Model.method800();
        Class37.method433(-29013);
        RSRuntimeException.method1053(-124);
        Class26.method350(0);
        SceneTile.method534(-95);
        InteractiveObject.method280(true);
        Class32.method401(94);
        Renderable.method757((byte) -117);
        Wall.method237(arg0 ^ 0x6df9);
        WallDecoration.method952(0);
        FloorDecoration.method348(arg0 + -34645);
        Class52.method946(false);
        Class11.method239();
        KeyFocusListener.method953((byte) -38);
        GameFrame.method1001(true);
        Class51.method939(-108);
        SubNode.method541(117);
        CacheIndex.method180(arg0 ^ arg0);
        Class44.method896(arg0 ^ ~0x6da1);
        Class33.method408(arg0 + -6046);
        Class8.method214();
        Class55.method961(1);
        Class60.method994(false);
        Class65.method1017((byte) -25);
        Class27.method356(arg0 ^ ~0x6ced);
        Class40_Sub5_Sub13.method653(-1);
        Landscape.method935(10582);
        Rasterizer3D.method704();
        Rasterizer.method667();
        Class42.method887((byte) -108);
        Class24.method339((byte) -41);
        Class17.method277((byte) 83);
        OverlayDefinition.method554((byte) 122);
        UnderlayDefinition.method621(arg0 ^ 0x6da1);
        IdentityKit.method625(0);
        GameObjectDefinition.method604(true);
        ItemDefinition.method745();
        Class40_Sub5_Sub15.method734(76);
        SpotAnimDefinition.method548(-3254);
        VarbitDefinition.method565(-124);
        Class40_Sub5_Sub11.method632(-1);
        Class35.method423((byte) -81);
        EntryTable.method871();
        HuffmanEncoding.method1022(-125);
        Class59.method985((byte) -127);
        Class5.method163((byte) -94);
        Class40_Sub2.method524(-9019);
        Class40_Sub5_Sub1.method542(-27934);
        Class4.method159();
        VertexNormal.method914(arg0 + -28113);
        Class40_Sub5_Sub17_Sub1.method761((byte) 113);
        Class40_Sub5_Sub17_Sub6.method835((byte) 98);
        Class12.method240((byte) -76);
        Class43.method893((byte) 127);
        Class61.method998(-128);
        GameObject.method770();
        Class40_Sub5_Sub17_Sub3.method780(24399);
        Class40_Sub7.method839(arg0 ^ 0x6d9e);
        Class13.method248(arg0 ^ 0x925e);
        RSCanvas.method47((byte) -46);
        Class38_Sub1.method449(arg0 + -50848);
        Class68_Sub1.method1047();
        GroundItemTile.method981();
        Filter.method268();
        Class57.method974();
        Class41.method881();
        Class40_Sub13.method877(0);
        Class21.method289();
        Class34.method418(7679);
        Class40_Sub6.method837((byte) 59);
        Class22.method298(120);
        Class40_Sub5_Sub6.method582(true);
        Class8_Sub1.method220();
        Class8_Sub1_Sub1.method228();
        Class29.method370(8);
        Class40_Sub11.method874((byte) 101);
        Class22_Sub2.method320(39);
        Class14.method266();
        Class22_Sub1.method310(77);
    }

    public void method31(boolean arg0) {
        CollisionMap.anInt172 = Class44.modewhere == 0 ? 443 : 50000 + Class13.worldid;
        OverlayDefinition.anInt2340 = (Class44.modewhere != 0 ? Class13.worldid + 40000 : 43594);
        if(!arg0)
            aBoolean1790 = true;
        Wall.anInt350 = OverlayDefinition.anInt2340;
        Class61.method997(47);
        Widget.method642(GameFrame.aCanvas1469, -10);
        RSRuntimeException.method1056(GameFrame.aCanvas1469, (byte) 70);
        RSCanvas.anInt57 = Signlink.anInt737;
        try {
            if(ISAAC.aClass31_521.cacheData != null) {
                SpotAnimDefinition.aClass67_2298 = new Class67(ISAAC.aClass31_521.cacheData, 5200, 0);
                for(int i = 0; i < 13; i++)
                    Class40_Sub5_Sub6.aClass67Array2436[i] = new Class67((ISAAC.aClass31_521.cacheIndex[i]), 6000, 0);
                Class30.aClass67_693 = new Class67(ISAAC.aClass31_521.aClass47_728, 6000, 0);
                VarbitDefinition.aClass56_2356 = new Class56(255, SpotAnimDefinition.aClass67_2298, Class30.aClass67_693, 500000);
                ISAAC.aClass31_521.cacheIndex = null;
                ISAAC.aClass31_521.aClass47_728 = null;
                ISAAC.aClass31_521.cacheData = null;
            }
        } catch(java.io.IOException ioexception) {
            VarbitDefinition.aClass56_2356 = null;
            SpotAnimDefinition.aClass67_2298 = null;
            Class30.aClass67_693 = null;
        }
        if(Class44.modewhere != 0)
            InteractiveObject.showFps = true;
        Class12.chatboxInterface = new Widget();
    }
}
