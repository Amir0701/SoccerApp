package com.example.soccerapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.example.soccerapp.R
import com.example.soccerapp.util.Util
import com.onesignal.OneSignal

class WebViewFragment : Fragment() {
    private lateinit var web: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(requireContext())
        OneSignal.setAppId(Util.ONESIGNAL_APP_ID)

        web = view.findViewById(R.id.webView)
    }

    override fun onStart() {
        super.onStart()
        web.loadUrl("https://en.wikipedia.org/wiki/Main_Page")
    }
}