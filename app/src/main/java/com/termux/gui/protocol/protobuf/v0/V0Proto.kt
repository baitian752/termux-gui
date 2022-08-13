package com.termux.gui.protocol.protobuf.v0

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.PixelFormat
import android.net.LocalSocket
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.Gravity
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.WindowManager
import android.widget.Toast
import com.termux.gui.GUIActivity
import com.termux.gui.R
import com.termux.gui.Util
import com.termux.gui.protocol.shared.v0.DataClasses
import com.termux.gui.protocol.shared.v0.V0Shared
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import com.termux.gui.protocol.protobuf.v0.GUIProt0.*

class V0Proto(app: Context, private val eventQueue: LinkedBlockingQueue<Event>) : V0Shared(app) {
    


    fun handleConnection(main: LocalSocket) {
        val am = app.getSystemService(ActivityManager::class.java)
        val wm = app.getSystemService(WindowManager::class.java)
        withSystemListenersAndCleanup(am, wm) {
            val input = main.inputStream
            val out = main.outputStream
            val handleActivity = HandleActivity(this, out, activities, wm, overlays)
            val handleGlobal = HandleGlobal(out,  tasks)
            while (! Thread.currentThread().isInterrupted) {
                val m = Method.parseDelimitedFrom(input)
                when (m.methodCase) {
                    Method.MethodCase.NEWACTIVITY -> handleActivity.newActivity(m.newActivity)
                    Method.MethodCase.FINISHACTIVITY -> handleActivity.finishActivity(m.finishActivity)
                    Method.MethodCase.FINISHTASK -> handleGlobal.finishTask(m.finishTask)
                    Method.MethodCase.BRINGTASKTOFRONT -> handleGlobal.bringTaskToFront(m.bringTaskToFront)
                    Method.MethodCase.MOVETASKTOBACK -> handleActivity.moveTaskToBack(m.moveTaskToBack)
                    Method.MethodCase.SETTHEME -> handleActivity.setTheme(m.setTheme)
                    Method.MethodCase.SETTASKDESCRIPTION -> TODO()
                    Method.MethodCase.SETPIPPARAMS -> TODO()
                    Method.MethodCase.SETINPUTMODE -> TODO()
                    Method.MethodCase.SETPIPMODE -> TODO()
                    Method.MethodCase.SETPIPMODEAUTO -> TODO()
                    Method.MethodCase.TOAST -> TODO()
                    Method.MethodCase.KEEPSCREENON -> TODO()
                    Method.MethodCase.SETORIENTATION -> TODO()
                    Method.MethodCase.SETPOSITION -> TODO()
                    Method.MethodCase.GETCONFIGURATION -> TODO()
                    Method.MethodCase.TURNSCREENON -> TODO()
                    Method.MethodCase.ISLOCKED -> TODO()
                    Method.MethodCase.REQUESTUNLOCK -> TODO()
                    Method.MethodCase.HIDESOFTKEYBOARD -> TODO()
                    Method.MethodCase.INTERCEPTBACKBUTTON -> TODO()
                    Method.MethodCase.VERSION -> TODO()
                    Method.MethodCase.CREATELINEARLAYOUT -> TODO()
                    Method.MethodCase.CREATEFRAMELAYOUT -> TODO()
                    Method.MethodCase.CREATESWIPEREFRESHLAYOUT -> TODO()
                    Method.MethodCase.CREATETEXTVIEW -> TODO()
                    Method.MethodCase.CREATEEDITTEXT -> TODO()
                    Method.MethodCase.CREATEBUTTON -> TODO()
                    Method.MethodCase.CREATEIMAGEVIEW -> TODO()
                    Method.MethodCase.CREATESPACE -> TODO()
                    Method.MethodCase.CREATENESTEDSCROLLVIEW -> TODO()
                    Method.MethodCase.CREATEHORIZONTALSCROLLVIEW -> TODO()
                    Method.MethodCase.CREATERADIOGROUP -> TODO()
                    Method.MethodCase.CREATERADIOBUTTON -> TODO()
                    Method.MethodCase.CREATECHECKBOX -> TODO()
                    Method.MethodCase.CREATETOGGLEBUTTON -> TODO()
                    Method.MethodCase.CREATESWITCH -> TODO()
                    Method.MethodCase.CREATESPINNER -> TODO()
                    Method.MethodCase.CREATEPROGRESSBAR -> TODO()
                    Method.MethodCase.CREATETABLAYOUT -> TODO()
                    Method.MethodCase.CREATEWEBVIEW -> TODO()
                    Method.MethodCase.SHOWCURSOR -> TODO()
                    Method.MethodCase.SETLINEARLAYOUT -> TODO()
                    Method.MethodCase.SETGRIDLAYOUT -> TODO()
                    Method.MethodCase.SETLOCATION -> TODO()
                    Method.MethodCase.SETRELATIVE -> TODO()
                    Method.MethodCase.SETVISIBILITY -> TODO()
                    Method.MethodCase.SETWIDTH -> TODO()
                    Method.MethodCase.SETHEIGHT -> TODO()
                    Method.MethodCase.GETDIMENSIONS -> TODO()
                    Method.MethodCase.DELETEVIEW -> TODO()
                    Method.MethodCase.DELETECHILDREN -> TODO()
                    Method.MethodCase.SETMARGIN -> TODO()
                    Method.MethodCase.SETPADDING -> TODO()
                    Method.MethodCase.SETBACKGROUNDCOLOR -> TODO()
                    Method.MethodCase.SETTEXTCOLOR -> TODO()
                    Method.MethodCase.SETPROGRESS -> TODO()
                    Method.MethodCase.SETREFRESHING -> TODO()
                    Method.MethodCase.SETTEXT -> TODO()
                    Method.MethodCase.SETGRAVITY -> TODO()
                    Method.MethodCase.SETTEXTSIZE -> TODO()
                    Method.MethodCase.GETTEXT -> TODO()
                    Method.MethodCase.REQUESTFOCUS -> TODO()
                    Method.MethodCase.GETSCROLLPOSITION -> TODO()
                    Method.MethodCase.SETSCROLLPOSITION -> TODO()
                    Method.MethodCase.SETLIST -> TODO()
                    Method.MethodCase.SETIMAGE -> TODO()
                    Method.MethodCase.ADDBUFFER -> TODO()
                    Method.MethodCase.DELETEBUFFER -> TODO()
                    Method.MethodCase.BLITBUFFER -> TODO()
                    Method.MethodCase.SETBUFFER -> TODO()
                    Method.MethodCase.REFRESHIMAGEVIEW -> TODO()
                    Method.MethodCase.SELECTTAB -> TODO()
                    Method.MethodCase.SETCLICKABLE -> TODO()
                    Method.MethodCase.CREATEREMOTELAYOUT -> TODO()
                    Method.MethodCase.DELETEREMOTELAYOUT -> TODO()
                    Method.MethodCase.ADDREMOTEFRAMELAYOUT -> TODO()
                    Method.MethodCase.ADDREMOTELINEARLAYOUT -> TODO()
                    Method.MethodCase.ADDREMOTETEXTVIEW -> TODO()
                    Method.MethodCase.ADDREMOTEBUTTON -> TODO()
                    Method.MethodCase.ADDREMOTEIMAGEVIEW -> TODO()
                    Method.MethodCase.ADDREMOTEPROGRESSBAR -> TODO()
                    Method.MethodCase.SETREMOTEBACKGROUNDCOLOR -> TODO()
                    Method.MethodCase.SETREMOTEPROGRESSBAR -> TODO()
                    Method.MethodCase.SETREMOTETEXT -> TODO()
                    Method.MethodCase.SETREMOTETEXTSIZE -> TODO()
                    Method.MethodCase.SETREMOTETEXTCOLOR -> TODO()
                    Method.MethodCase.SETREMOTEVISIBILITY -> TODO()
                    Method.MethodCase.SETREMOTEPADDING -> TODO()
                    Method.MethodCase.SETREMOTEIMAGE -> TODO()
                    Method.MethodCase.SETWIDGETLAYOUT -> TODO()
                    Method.MethodCase.ALLOWJS -> TODO()
                    Method.MethodCase.ALLOWCONTENT -> TODO()
                    Method.MethodCase.SETDATA -> TODO()
                    Method.MethodCase.LOADURI -> TODO()
                    Method.MethodCase.ALLOWNAVIGATION -> TODO()
                    Method.MethodCase.GOBACK -> TODO()
                    Method.MethodCase.GOFORWARD -> TODO()
                    Method.MethodCase.EVALUATEJS -> TODO()
                    Method.MethodCase.CREATECHANNEL -> TODO()
                    Method.MethodCase.CREATENOTIFICATION -> TODO()
                    Method.MethodCase.CANCELNOTIFICATION -> TODO()
                    Method.MethodCase.SENDCLICKEVENT -> TODO()
                    Method.MethodCase.SENDLONGCLICKEVENT -> TODO()
                    Method.MethodCase.SENDFOCUSCHANGEEVENT -> TODO()
                    Method.MethodCase.SENDTOUCHEVENT -> TODO()
                    Method.MethodCase.SENDGESTUREEVENT -> TODO()
                    Method.MethodCase.SENDTEXTEVENT -> TODO()
                    Method.MethodCase.SENDOVERLAYTOUCH -> TODO()
                    Method.MethodCase.METHOD_NOT_SET -> { return@withSystemListenersAndCleanup } // terminate the connection when nothing is in the oneof
                    null -> { return@withSystemListenersAndCleanup } // terminate the connection when nothing is in the oneof
                }
            }
        }
    }

    override fun onActivityCreated(state: DataClasses.ActivityState) {
        eventQueue.offer(Event.newBuilder().setCreate(CreateEvent.newBuilder().setAid(state.a?.aid)).build())
    }

    override fun onActivityStarted(state: DataClasses.ActivityState) {
        eventQueue.offer(Event.newBuilder().setStart(StartEvent.newBuilder().setAid(state.a?.aid)).build())
    }

    override fun onActivityResumed(state: DataClasses.ActivityState) {
        eventQueue.offer(Event.newBuilder().setResume(ResumeEvent.newBuilder().setAid(state.a?.aid)).build())
    }

    override fun onActivityPaused(state: DataClasses.ActivityState) {
        eventQueue.offer(Event.newBuilder().setPause(PauseEvent.newBuilder().setAid(state.a?.aid).setFinishing(state.a?.isFinishing ?: false)).build())
    }

    override fun onActivityStopped(state: DataClasses.ActivityState) {
        eventQueue.offer(Event.newBuilder().setStop(StopEvent.newBuilder().setAid(state.a?.aid).setFinishing(state.a?.isFinishing ?: false)).build())
    }

    override fun onActivityDestroyed(state: DataClasses.ActivityState) {
        eventQueue.offer(Event.newBuilder().setDestroy(DestroyEvent.newBuilder().setAid(state.a?.aid).setFinishing(state.a?.isFinishing ?: false)).build())
    }

    override fun onAirplaneModeChanged(c: Context, i: Intent) {
        eventQueue.offer(Event.newBuilder().setAirplane(AirplaneEvent.newBuilder().setActive(i.getBooleanExtra("state", false))).build())
    }

    override fun onLocaleChanged(c: Context, i: Intent) {
        eventQueue.offer(Event.newBuilder().setLocale(LocaleEvent.newBuilder().setLocale(c.resources.configuration.locales.get(0).language)).build())
    }

    override fun onScreenOff(c: Context, i: Intent) {
        eventQueue.offer(Event.newBuilder().setScreenOff(ScreenOffEvent.newBuilder()).build())
    }

    override fun onScreenOn(c: Context, i: Intent) {
        eventQueue.offer(Event.newBuilder().setScreenOn(ScreenOnEvent.newBuilder()).build())
    }

    override fun onTimezoneChanged(c: Context, i: Intent) {
        eventQueue.offer(Event.newBuilder().setTimezone(TimezoneEvent.newBuilder().setTz(TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT, c.resources.configuration.locales.get(0)))).build())
    }
    
    override fun onBackButton(a: GUIActivity) {
        eventQueue.offer(Event.newBuilder().setBack(BackButtonEvent.newBuilder().setAid(a.aid)).build())
    }

    override fun onRemoteButton(rid: Int, id: Int) {
        eventQueue.offer(Event.newBuilder().setRemoteClick(RemoteClickEvent.newBuilder().setRid(rid).setId(id)).build())
    }

    override fun onNotification(nid: Int) {
        eventQueue.offer(Event.newBuilder().setNotification(NotificationEvent.newBuilder().setId(nid)).build())
    }

    override fun onNotificationDismissed(nid: Int) {
        eventQueue.offer(Event.newBuilder().setNotificationDismissed(NotificationDismissedEvent.newBuilder().setId(nid)).build())
    }

    override fun onNotificationAction(nid: Int, action: Int) {
        eventQueue.offer(Event.newBuilder().setNotificationAction(NotificationActionEvent.newBuilder().setId(nid).setAction(action)).build())
    }

    override fun onConfigurationChanged(a: GUIActivity, newConfig: Configuration) {
        val e = ConfigEvent.newBuilder()
        val c = GUIProt0.Configuration.newBuilder()
        e.aid = a.aid
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            c.darkMode = newConfig.isNightModeActive
        }
        val l = newConfig.locales.get(0)
        c.country = l.country
        c.language = l.language
        c.orientation = when (newConfig.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> GUIProt0.Configuration.Orientation.landscape
            Configuration.ORIENTATION_PORTRAIT -> GUIProt0.Configuration.Orientation.portrait
            else -> GUIProt0.Configuration.Orientation.portrait
        }
        c.keyboardHidden = when (newConfig.keyboardHidden) {
            Configuration.KEYBOARDHIDDEN_NO -> false
            Configuration.KEYBOARDHIDDEN_YES -> true
            else -> true
        }
        c.screenWidth = newConfig.screenWidthDp
        c.screenHeight = newConfig.screenHeightDp
        c.fontscale = newConfig.fontScale
        c.density = a.resources.displayMetrics.density
        e.setConfiguration(c)
        eventQueue.offer(Event.newBuilder().setConfig(e).build())
    }

    override fun onPictureInPictureModeChanged(a: GUIActivity, isInPictureInPictureMode: Boolean) {
        eventQueue.offer(Event.newBuilder().setPip(PiPChangedEvent.newBuilder().setPip(isInPictureInPictureMode).setAid(a.aid)).build())
    }

    override fun onUserLeaveHint(a: GUIActivity) {
        eventQueue.offer(Event.newBuilder().setUserLeaveHint(UserLeaveHintEvent.newBuilder().setAid(a.aid)).build())
    }

    @Suppress("DEPRECATION")
    fun generateOverlay(): String {
        val wm = app.getSystemService(WindowManager::class.java)
        if (!Settings.canDrawOverlays(app)) {
            try {
                val a = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                a.data = Uri.parse(app.packageName)
                app.startActivity(a)
            } catch (ignored: Exception) {
                Util.runOnUIThreadBlocking {
                    Toast.makeText(app, R.string.overlay_settings, Toast.LENGTH_LONG).show()
                }
            }
            return ""
        } else {
            val aid = generateActivityID()
            val o = DataClasses.Overlay(app)
            overlays[aid] = o
            try {
                Util.runOnUIThreadBlocking {
                    val params = WindowManager.LayoutParams(
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY else WindowManager.LayoutParams.TYPE_PHONE,
                        0,
                        PixelFormat.RGBA_8888
                    )
                    params.x = 0
                    params.y = 0
                    params.gravity = Gravity.START or Gravity.TOP
                    params.flags =
                        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    val scale = ScaleGestureDetector(
                        app,
                        object : ScaleGestureDetector.OnScaleGestureListener {
                            override fun onScale(detector: ScaleGestureDetector?): Boolean {
                                if (o.sendTouch && detector != null) {
                                    eventQueue.offer(Event.newBuilder().setOverlayScale(OverlayScaleEvent.newBuilder()
                                        .setAid(aid)
                                        .setSpan(detector.currentSpan)
                                    ).build())
                                }
                                return true
                            }

                            override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
                                return true
                            }

                            override fun onScaleEnd(detector: ScaleGestureDetector?) {}
                        })
                    o.root.interceptListener = { e ->
                        if (o.sendTouch) {
                            val map = HashMap<String, Any?>()
                            map["x"] = e.rawX
                            map["y"] = e.rawY
                            val action = when (e.action) {
                                MotionEvent.ACTION_DOWN -> TouchEvent.Action.down
                                MotionEvent.ACTION_UP -> TouchEvent.Action.up
                                MotionEvent.ACTION_MOVE -> TouchEvent.Action.move
                                else -> null
                            }
                            if (map["action"] != null) {
                                eventQueue.offer(Event.newBuilder().setTouch(TouchEvent.newBuilder()
                                    .setV(View.newBuilder().setAid(aid).setId(-1))
                                    .setAction(action)
                                    .addTouches(TouchEvent.Touch.newBuilder().addPointers(TouchEvent.Touch.Pointer.newBuilder().setX(
                                        e.rawX.toInt()
                                    ).setY(e.rawY.toInt()).setId(0)))
                                    .setTime(System.currentTimeMillis())
                                    .setIndex(0)
                                ).build())
                            }
                        }
                        if (o.root.inside(e)) {
                            scale.onTouchEvent(e)
                            params.flags = 0
                            wm.updateViewLayout(o.root, params)
                        } else {
                            scale.onTouchEvent(e)
                            params.flags =
                                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            wm.updateViewLayout(o.root, params)
                        }
                    }
                    wm.addView(o.root, params)
                }
                return aid
            } catch (e: Exception) {
                e.printStackTrace()
                overlays.remove(aid)
                return ""
            }
        }
    }
    
}