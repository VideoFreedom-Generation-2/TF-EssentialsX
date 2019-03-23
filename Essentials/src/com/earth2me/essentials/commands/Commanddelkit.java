package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.User;
import org.bukkit.Server;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.earth2me.essentials.I18n.tl;

public class Commanddelkit extends EssentialsCommand {

    public Commanddelkit() {
        super("deletekit");
    }

    @Override
    public void run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception {
        if (args.length != 1) {
            throw new NotEnoughArgumentsException();
        }

        String name = String.join(" ", args).toLowerCase();

        if (ess.getKits().getKits().getKeys(false).contains(name)) {
            ess.getKits().deleteKit(name);
            user.sendMessage(tl("deletedKit", name));
        }
        else {
            throw new Exception(tl("kitNotFound"));
        }
    }

    @Override
    protected List<String> getTabCompleteOptions(final Server server, final CommandSource sender, final String commandLabel, final String[] args) {
        if (args.length == 1) {
            try {
                return new ArrayList<>(ess.getKits().getKits().getKeys(false));
            } catch (Exception e) {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }
}