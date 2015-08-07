package com.flashvisions.server.rtmp.transcoder.pojo.base;

import com.flashvisions.server.rtmp.transcoder.interfaces.IPassThruObject;
import com.flashvisions.server.rtmp.transcoder.interfaces.ITranscoderEntity;

public abstract class PassThruObject extends TranscoderEntity implements IPassThruObject, ITranscoderEntity {

	private boolean sameAsSource;
	private boolean ignore = false;
	
	@Override
	public void setSameAsSource(boolean sameAsSource) {
		// TODO Auto-generated method stub
		this.sameAsSource = sameAsSource;
	}

	@Override
	public boolean getSameAsSource() {
		// TODO Auto-generated method stub
		return sameAsSource;
	}
	
	@Override
	public void setIgnore(boolean ignore) {
		// TODO Auto-generated method stub
		this.ignore = ignore;
	}

	@Override
	public boolean getIgnore() {
		// TODO Auto-generated method stub
		return ignore;
	}
}
