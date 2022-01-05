package at.flokei.boundary;

import at.flokei.Greeter;
import at.flokei.HelloReply;
import at.flokei.HelloRequest;
import at.flokei.control.BookingRepository;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.vertx.AsyncResultUni;

import javax.inject.Inject;

@GrpcService
public class HelloService implements Greeter {

    @Inject
    BookingRepository bookingRepository;

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item(() -> {
            return bookingRepository.getBookingsOfCustomer(request.getName()).size(); // Panache entity
        }).runSubscriptionOn(Infrastructure.getDefaultExecutor())
                .onItem().transform(i -> HelloReply.newBuilder().setMessage("Bookings of " + request.getName() +": "+Integer.toString(i)).build());
    }
}