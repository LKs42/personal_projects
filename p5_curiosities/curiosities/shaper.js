let Balls = [];

function setup() {
  createCanvas(1200, 750);
  background(18, 18, 18);
  frameRate(60);
}

function draw() {
  background(18, 18, 18);
  for (let i = 0; i < Balls.length; i++) {
    for (let j = 0; j < Balls.length; j++) {
      //  stroke(Balls[i].colorr,Balls[i].colorg,Balls[i].colorb);
      stroke(255);
      line(Balls[i].x, Balls[i].y, Balls[j].x, Balls[j].y);

    }
  }
  for (let k = Balls.length - 1; k >= 0; k--) {
    //Balls[k].update();
//  if Balls[k].hovered() {
  ////  cursor(HAND);
  //}
//  else{
  //  cursor(ARROW);
  //}
    Balls[k].update();
    Balls[k].show();
  }
}

function mousePressed() {
  let b = new Ball(mouseX, mouseY);
  Balls.push(b);
}
class Ball {
  constructor(x, y) {
    this.x = x;
    this.y = y;
    this.radius = 100;
    this.colorr = random(1, 255);
    this.colorg = random(1, 255);
    this.colorb = random(1, 255);
  }
  show() {
    stroke(255);
    noFill();
    //  fill(this.colorr,this.colorg,this.colorb);
    ellipse(this.x, this.y, this.radius);
  }
  hovered(){
    if (mouseX > (this.x - (this.radius / 2))) {
      if (mouseX < (this.x + (this.radius / 2))) {
        if (mouseY < (this.y + (this.radius / 2))) {
          if (mouseY > (this.y - (this.radius / 2))) {
            return true;
          } else {
          return false;
          }
        } else {

        }
      } else {

      }
    } else {

    }
  }
  update() {

    //    this.x = mouseX;
    //  this.y = mouseY;
  }
}
