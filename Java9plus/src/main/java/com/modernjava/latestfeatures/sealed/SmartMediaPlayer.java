package com.modernjava.latestfeatures.sealed;

public sealed interface SmartMediaPlayer permits Car {
	
	void connectPhone();

}
