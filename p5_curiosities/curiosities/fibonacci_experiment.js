var val1 = 0;
var val2 = 1;
var valA = 0;
var valx = 0;

var addSlider;
var add = 1;

var bval1 = 1;
var bval2 = 1;
var bvalA = add;
var bvalx = 0;




var x;
var y;

var bx;
var by;

function setup() {
  createCanvas(windowWidth, windowHeight);
  background(18,18,18);


  addSlider = createSlider(0, 10, 1, 0.1);
  addSlider.size(1000);
  addSlider.position(windowWidth/2 - 500, 20);
  addSlider.changed(resetvalue);
}

function draw() {
  push();
  noStroke();
  text(add, addSlider.x + addSlider.width, 20);
  pop();
  //print(x);
  //print(y);

//addSLider.changed(resetvalue);
//add = addSlider.value();


  print(valx);

  stroke(255);
  valx = val1 + val2;

  x = valx * cos(valA);
  y = valx * sin(valA);

  valA += add;
  val1 = val2;
  val2 = valx;

  bvalx = bval1 + bval2;

  bx = bvalx * cos(bvalA);
  by = bvalx * sin(bvalA);

  push();
  translate(width / 2, height / 2);
  fill(255);
  ellipse(x,y,5,5);
  line(x,y,bx,by);
  pop();

  bvalA += add;
  bval1 = bval2;
  bval2 = bvalx;
}

function resetvalue()
{
  background(18,18,18);
   val1 = 0;
   val2 = 1;
   valA = 0;
   valx = 0;
   addSlider;
   add = addSlider.value();
   bval1 = 1;
   bval2 = 1;
   bvalA = add;
   bvalx = 0;
}
