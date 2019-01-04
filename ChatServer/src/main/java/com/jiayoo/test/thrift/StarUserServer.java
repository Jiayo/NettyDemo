package com.jiayoo.test.thrift;

import com.jiayoo.thrift.generated.UserService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class StarUserServer extends Thread {
    TServer server = null;
    public static void main(String[] args){
        new StarUserServer().run();
    }


    @Override
    public void run() {
        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(8890);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(1).maxWorkerThreads(10);
        UserService.Processor<ServerImpl> processor = new UserService.Processor<>(new ServerImpl());
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        server = new THsHaServer(arg);
        System.out.println("Thrift Server Started!");
        server.serve();

    }
}
