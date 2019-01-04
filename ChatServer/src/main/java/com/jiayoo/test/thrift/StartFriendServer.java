package com.jiayoo.test.thrift;

import com.jiayoo.thrift.generated.Friend;
import com.jiayoo.thrift.generated.FriendService;
import com.jiayoo.thrift.generated.UserService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class StartFriendServer extends  Thread{

    public static void main(String[] args){
        new StartFriendServer().run();
    }

    @Override
    public void run() {

        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(8801);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        FriendService.Processor<ServerImpl> processor = new FriendService.Processor<>(new ServerImpl());
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        TServer server = new THsHaServer(arg);
        System.out.println("Thrift FriendServer Started!");
       server.serve();
        server.stop();
    }
}
