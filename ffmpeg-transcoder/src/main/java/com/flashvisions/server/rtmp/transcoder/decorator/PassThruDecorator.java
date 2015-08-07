package com.flashvisions.server.rtmp.transcoder.decorator;

import com.flashvisions.server.rtmp.transcoder.decorator.PropertyDecorator;
import com.flashvisions.server.rtmp.transcoder.interfaces.IPassThru;
import com.flashvisions.server.rtmp.transcoder.interfaces.ITranscoderEntity;

public class PassThruDecorator extends PropertyDecorator implements IPassThru {

	private boolean sameAsSource;
	private boolean ignore = false;
	
	public PassThruDecorator(ITranscoderEntity property)
	{
		super(property);
	}

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
