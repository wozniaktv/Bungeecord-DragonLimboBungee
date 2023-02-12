package wozniaktv.me

import net.md_5.bungee.api.config.ServerInfo
import net.md_5.bungee.api.plugin.Plugin
import wozniaktv.me.limbo.Events
import java.util.UUID

class Main : Plugin() {

    var fromWhere : HashMap<UUID,ServerInfo> ?= null

    companion object{

        @JvmStatic
        lateinit var instance: Main

    }


    private fun instanceVariables(){

        instance = this
        fromWhere= HashMap()

    }

    override fun onEnable() {

        proxy.logger.info("Instancing objects and classes...")

        instanceVariables()

        proxy.logger.info("Everything instanced successfully!")

        proxy.logger.info("Registering listeners...")

        registerListeners()

        proxy.logger.info("Listeners registered successfully")

        proxy.logger.info("DragonicLimboBungee Enabled successfully")

    }

    private fun registerListeners(){

        proxy.pluginManager.registerListener(this, Events())

    }


    override fun onDisable() {

        proxy.logger.info("DragonicLimboBungee Disabled successfully")

    }


}