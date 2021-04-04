package com.example.practicafinalvictorpaz

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicafinalvictorpaz.databinding.FragmentVideoBinding

class FragmentVideo : Fragment() {

    private lateinit var homeViewModel: FragmentVideoViewModel
    private lateinit var homeBinding: FragmentVideoBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(FragmentVideoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_video, container, false)
        homeBinding = FragmentVideoBinding.bind(root)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val path = "android.resource://" + activity?.packageName + "/" + R.raw.video
        val video =homeBinding.video
        video.setVideoURI(Uri.parse(path))
        val play=homeBinding.play
        val pause=homeBinding.pause
        play.setOnClickListener { video.start()}
        pause.setOnClickListener { video.pause()}
    }

}