package no.hvl.dat110.messaging;

import java.util.Arrays;
import java.util.Base64;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		// TODO: check for length within boundary
		
			this.payload = payload; 
			
		
		
		
	}

	public Message() {
		super();
	}
	

	public byte[] getData() {
		return this.payload; 
	}
	
	public boolean sjekklengde(byte[] payload) {
		if(payload.length <128) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	

	public byte[] encapsulate() {
		
		byte[] encoded = null;
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
		
		
		
		
		
		byte lengde=(byte) payload.length;
		
		if(sjekklengde(this.payload)) {
			
			byte [] extend = new byte[payload.length+1]; //array lenght 57
			for(int i=0;i<payload.length;i++) {
				extend[i+1]=payload[i]; //alt fra payload blir flyttet lengre bak for å lage plass
				
			}
			payload=extend;
			payload[0]=lengde;
			
			for(int i=0;i<128;i++) {
				encoded=Arrays.copyOf(payload,i+1);
			}
		}
	
		return encoded;
		
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		int lengde= received[0];
		byte[] decode =new byte[lengde];
		
		for(int i=0; i<decode.length;i++) {
			decode[i]=received[i+1];
			
		}
		this.payload=decode;
	}
}
