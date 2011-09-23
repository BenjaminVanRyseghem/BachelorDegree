var x1 >=0;
var x2 >=0;
minimize z:x2-x1;
subject to c1: -2*x1+x2 <= 2;
subject to c2: x1+2*x2 <= 2;
subject to c3: x1+x2 <= 5;

