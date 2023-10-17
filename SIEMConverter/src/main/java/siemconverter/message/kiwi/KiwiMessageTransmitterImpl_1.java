
package siemconverter.message.kiwi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import siemconverter.message.IMessageTransmitter;

public class KiwiMessageTransmitterImpl_1 implements IMessageTransmitter {

	private static final Logger	LOGGER	= LoggerFactory.getLogger( KiwiMessageTransmitterImpl_1.class );

	@Override
	public void send( final String message ) {
		LOGGER.warn("Sentrifugo :{} ", message );
                            
	}
}
