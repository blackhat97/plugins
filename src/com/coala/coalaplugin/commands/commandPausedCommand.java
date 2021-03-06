package com.coala.coalaplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.coala.coalaplugin.Main;

public class commandPausedCommand implements CommandExecutor{
	public Main pl;
	
	public commandPausedCommand(Main instance)
	{
		this.pl = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.isOp()) {
			sender.sendMessage("관리자만 사용 가능합니다.");
			return false;
		} else if(args.length != 1) {
			sender.sendMessage("§c사용법: /commandPaused <true|false>");
			return false;
		}
		
		if(args[0].equals("true")) {
			this.pl.isCommandPaused = true;
			Bukkit.broadcastMessage("관리자를 제외한 플레이어의 명령어 사용이 제한되었습니다.");
			return true;
		} else if (args[0].equals("false")) {
			this.pl.isCommandPaused = false;
			Bukkit.broadcastMessage("관리자를 제외한 플레이어의 명령어 사용이 허용되었습니다.");
			return true;
		} else {
			sender.sendMessage("§c사용법: /commandPaused <true|false>");
			return false;
		}
	}

}
