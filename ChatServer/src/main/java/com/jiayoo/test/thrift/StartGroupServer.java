package com.jiayoo.test.thrift;

import com.jiayoo.thrift.generated.FriendService;
import com.jiayoo.thrift.generated.Group;
import com.jiayoo.thrift.generated.GroupService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class StartGroupServer {

    public static void main(String[] args){

        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(8802);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        GroupService.Processor<GroupServerImpl> processor = new GroupService.Processor<>(new GroupServerImpl());
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        TServer server = new THsHaServer(arg);
        System.out.println("Thrift GroupServer Started!");
        server.serve();
        server.stop();


    }

}
