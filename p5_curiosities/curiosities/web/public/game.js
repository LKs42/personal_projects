let Balls = [];
let BallsEnemy = [];
let Bullets1 = [];
var socket;
function setup() {
  createCanvas(windowWidth, windowHeight);
  background(18, 18, 18);
  frameRate(60);
  socket = io.connect('http://localhost:3000');
  socket.on('bpos', newBall);
   let b = new BallEnemy(random(10, 300), 100);
  BallsEnemy.push(b);
}
function newBall(data)
{
  for (let u = BallsEnemy.length - 1; u >= 0; u--) {
    BallsEnemy[u].update(data.x, data.y);
  }
}
  
function draw() {
  background(18, 18, 18);
  print(BallsEnemy.length);
  for (let i = Bullets1.length - 1; i >= 0; i--) {
    Bullets1[i].update();
    Bullets1[i].show();
    if(Bullets1[i].finished())
      {
        Bullets1.splice(i,1);
      }
  }
  for (let k = Balls.length - 1; k >= 0; k--) {
    Balls[k].update();
    Balls[k].show();
    for(let j = Bullets1.length - 1; j >= 0; j--)
    {
      if(Balls[k].intersect(Bullets1[j]))
      {
        ellipse(50,50,50);
      }
    }
  }
  for (let u = BallsEnemy.length - 1; u >= 0; u--) {
    BallsEnemy[u].show();
  }
  
}

function mousePressed() {
  let b = new Ball(mouseX, mouseY);
  Balls.push(b);
}
function keyTyped(){
  if (key === 'a') {
    for (let i = Balls.length - 1; i >= 0; i--) {
      Balls[i].shoot();
    }
  }
}

class bullet1{
  constructor(x,y,d){
    this.radius = 5;
    this.x = x + (d ? +25 : -25);
    this.y = y;
    this.direction = d;
    this.speed = 20;
    this.color = 255;
  }
  update(){
    if(this.direction == true)
      this.x += this.speed;
    else{
      this.x -= this.speed;
    }
  }
  show(){
    fill(this.color);
    ellipse(this.x, this.y, this.radius);
  }
  finished(){
    if(this.x > windowWidth || this.x < 0)
      return(1);
    else
      return(0);
  }
}

class Ball {
  constructor(x, y) {
    this.x = x;
    this.y = y;
    this.speed = 10;
    this.gravity = 1;
    this.accel = 0.5;
    this.radius = 10;
    this.jump = 5;
    this.colorr = random(1, 255);
    this.colorg = random(1, 255);
    this.colorb = random(1, 255);
    this.spacepress = false;
    this.lookright = true;
  }
  intersect(b){
    let d = dist(this.x, this.y, b.x, b.y)
    if(d <= this.radius + b.radius)
      return (true);
    else
      return (false);
  }
  show() {
    stroke(255);
    fill(this.colorr,this.colorg,this.colorb);
    ellipse(this.x, this.y, this.radius);
  }
  shoot()
  {
    let b = new bullet1(this.x, this.y, this.lookright);
    Bullets1.push(b);
  }
  update()
  {
    this.y += this.gravity;
    this.gravity += this.accel;
    console.log('sending');
    var ballData = {
      x: this.x,
      y: this.y
    }

    socket.emit('bpos', ballData);
/*
    if (keyIsDown(SHIFT))
    {
       this.shoot();
    }
  */
    if (keyIsDown(LEFT_ARROW))
      {
        this.x -= this.speed;
        this.lookright = false;
      }
      if (keyIsDown(RIGHT_ARROW))
      {
        this.x += this.speed;
        this.lookright = true;
      }

      if(this.y + this.radius/2 >= windowHeight)
      {
        this.y = windowHeight - this.radius/2;
        this.spacepress = false;
        this.gravity = 0;
      }

      if (keyIsDown(UP_ARROW) && this.spacepress == false)
      {
        this.spacepress = true;
        this.gravity = -20;
      }
     
    if(this.x - this.radius/2 <= 0)
      this.x = this.radius/2;
    if(this.x + this.radius/2 >= windowWidth)
     this.x = windowWidth - this.radius/2;
  }
}

class BallEnemy {
  constructor(x, y) {
    this.x = x;
    this.y = y;
    this.radius = 10;
    this.colorr = random(1, 255);
    this.colorg = random(1, 255);
    this.colorb = random(1, 255);
    this.spacepress = false;
    this.lookright = true;
  }
  show() {
    stroke(255);
    fill(this.colorr,this.colorg,this.colorb);
    ellipse(this.x, this.y, this.radius);
  }
  update(x, y)
  {
    this.x =x;
    this.y = y;
  }
}


