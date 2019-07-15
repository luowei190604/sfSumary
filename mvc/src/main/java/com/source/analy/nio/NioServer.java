package com.source.analy.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();
		Selector selector = Selector.open();
		server.register(selector, SelectionKey.OP_ACCEPT);
		
		Set<SelectionKey> keys = selector.keys();
		if(keys.size()>=1){
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				iterator.remove();
				if(key.isReadable()){
					SelectableChannel channel = key.channel();
					channel.configureBlocking(false);
				}
			}
		}
	}
	
}
