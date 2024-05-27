package com.norm.myvideocallingapp.video

sealed interface VideoCallAction {
    data object OnDisconnectClick : VideoCallAction
    data object JoinCallClick : VideoCallAction
}