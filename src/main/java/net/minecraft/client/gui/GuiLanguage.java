package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.settings.GameSettings;

public class GuiLanguage extends GuiScreen
{
    protected GuiScreen field_146453_a;
    private GuiLanguage.List field_146450_f;
    private final GameSettings field_146451_g;
    private final LanguageManager field_146454_h;
    private GuiOptionButton field_146455_i;
    private GuiOptionButton field_146452_r;
    private static final String __OBFID = "CL_00000698";

    public GuiLanguage(GuiScreen par1GuiScreen, GameSettings par2GameSettings, LanguageManager par3LanguageManager)
    {
        this.field_146453_a = par1GuiScreen;
        this.field_146451_g = par2GameSettings;
        this.field_146454_h = par3LanguageManager;
    }

    public void initGui()
    {
        this.buttonList.add(this.field_146455_i = new GuiOptionButton(100, this.width / 2 - 155, this.height - 38, GameSettings.Options.FORCE_UNICODE_FONT, this.field_146451_g.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT)));
        this.buttonList.add(this.field_146452_r = new GuiOptionButton(6, this.width / 2 - 155 + 160, this.height - 38, I18n.format("gui.done", new Object[0])));
        this.field_146450_f = new GuiLanguage.List();
        this.field_146450_f.registerScrollButtons(7, 8);
    }

    protected void actionPerformed(GuiButton p_146284_1_)
    {
        if (p_146284_1_.enabled)
        {
            switch (p_146284_1_.id)
            {
                case 5:
                    break;

                case 6:
                    this.mc.displayGuiScreen(this.field_146453_a);
                    break;

                case 100:
                    if (p_146284_1_ instanceof GuiOptionButton)
                    {
                        this.field_146451_g.setOptionValue(((GuiOptionButton)p_146284_1_).returnEnumOptions(), 1);
                        p_146284_1_.displayString = this.field_146451_g.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
                    }

                    break;

                default:
                    this.field_146450_f.actionPerformed(p_146284_1_);
            }
        }
    }

    public void drawScreen(int par1, int par2, float par3)
    {
        this.field_146450_f.drawScreen(par1, par2, par3);
        this.drawCenteredString(this.fontRenderer, I18n.format("options.language", new Object[0]), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRenderer, "(" + I18n.format("options.languageWarning", new Object[0]) + ")", this.width / 2, this.height - 56, 8421504);
        super.drawScreen(par1, par2, par3);
    }

    class List extends GuiSlot
    {
        private final java.util.List field_148176_l = Lists.newArrayList();
        private final Map field_148177_m = Maps.newHashMap();
        private static final String __OBFID = "CL_00000699";

        public List()
        {
            super(GuiLanguage.this.mc, GuiLanguage.this.width, GuiLanguage.this.height, 32, GuiLanguage.this.height - 65 + 4, 18);
            Iterator var2 = GuiLanguage.this.field_146454_h.getLanguages().iterator();

            while (var2.hasNext())
            {
                Language var3 = (Language)var2.next();
                this.field_148177_m.put(var3.getLanguageCode(), var3);
                this.field_148176_l.add(var3.getLanguageCode());
            }
        }

        protected int getSize()
        {
            return this.field_148176_l.size();
        }

        protected void elementClicked(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_)
        {
            Language var5 = (Language)this.field_148177_m.get(this.field_148176_l.get(p_148144_1_));
            GuiLanguage.this.field_146454_h.setCurrentLanguage(var5);
            GuiLanguage.this.field_146451_g.language = var5.getLanguageCode();
            GuiLanguage.this.mc.refreshResources();
            GuiLanguage.this.fontRenderer.setUnicodeFlag(GuiLanguage.this.field_146454_h.isCurrentLocaleUnicode() || GuiLanguage.this.field_146451_g.forceUnicodeFont);
            GuiLanguage.this.fontRenderer.setBidiFlag(GuiLanguage.this.field_146454_h.isCurrentLanguageBidirectional());
            GuiLanguage.this.field_146452_r.displayString = I18n.format("gui.done", new Object[0]);
            GuiLanguage.this.field_146455_i.displayString = GuiLanguage.this.field_146451_g.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
            GuiLanguage.this.field_146451_g.saveOptions();
        }

        protected boolean isSelected(int p_148131_1_)
        {
            return ((String)this.field_148176_l.get(p_148131_1_)).equals(GuiLanguage.this.field_146454_h.getCurrentLanguage().getLanguageCode());
        }

        protected int getContentHeight()
        {
            return this.getSize() * 18;
        }

        protected void drawBackground()
        {
            GuiLanguage.this.drawDefaultBackground();
        }

        protected void drawSlot(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_)
        {
            GuiLanguage.this.fontRenderer.setBidiFlag(true);
            GuiLanguage.this.drawCenteredString(GuiLanguage.this.fontRenderer, ((Language)this.field_148177_m.get(this.field_148176_l.get(p_148126_1_))).toString(), this.width / 2, p_148126_3_ + 1, 16777215);
            GuiLanguage.this.fontRenderer.setBidiFlag(GuiLanguage.this.field_146454_h.getCurrentLanguage().isBidirectional());
        }
    }
}
