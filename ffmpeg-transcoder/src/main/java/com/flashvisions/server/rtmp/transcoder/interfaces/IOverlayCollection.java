package com.flashvisions.server.rtmp.transcoder.interfaces;

public interface IOverlayCollection {
	public void addOverlay(IOverlay o);
	public void removeOverlay(IOverlay o);
	public void clear();
	
    public IOverlayIterator iterator();
}
