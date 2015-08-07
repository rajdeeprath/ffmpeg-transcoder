package com.flashvisions.server.rtmp.transcoder.interfaces;

public interface ISessionObserver {
	public void onSessionPreStart(ISession session);
	public void onSessionStart(ISession session, Object data);
	public void onSessionComplete(ISession session, Object data);
	public void onSessionFailed(ISession session, Object data);
	public void onSessionData(ISession session, Object data);
	public void onSessionProcessAdded(ISession session, Process proc);
	public void onSessionProcessRemoved(ISession session, Process proc);
}
