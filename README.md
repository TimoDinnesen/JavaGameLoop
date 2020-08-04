# JavaGameLoop
A very simple but complete working example of a Java game loop with doublebuffered rendering.

A set of clases that correctly set up a double buffered rendering window, with a fixed ticks per second "physics" loop running along as well.

I was unable to find some working complete example of this online, so here it is.

I tried to code it according to newest Java Standards of 2020, but I'm a bit rusty, so some things could be a bit old fashioned :-)


There are several improvements that can be done:
The bufferstrategy really needs to do more work of figuring out how to perform best on the hardware it is running on.
In case of very slow rendering or physics loop, where the execution of the entire loop takes longer than a second, the current implementation will try to keep up, but will fail to do so.
Depending on what you want to draw, it may be useful to implement some sort of interpolation, to smooth out movement.



