package wozniaktv.me.limbo

import net.md_5.bungee.api.event.ServerSwitchEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler
import wozniaktv.me.Main

class Events : Listener {

    private var main : Main ?= null

    init{
        main = Main.instance
    }


    @EventHandler
    fun serverSwitch(event: ServerSwitchEvent){

        if(event.from.name == "limbo"){

            if(main!!.fromWhere!!.containsKey(event.player.uniqueId)){
                event.player.connect(main!!.fromWhere!![event.player.uniqueId])
                main!!.fromWhere!!.remove(event.player.uniqueId)
            }

        }

        if(event.player.server.info.name == "limbo"){

            main!!.fromWhere!![event.player.uniqueId] = event.from

        }

    }


}