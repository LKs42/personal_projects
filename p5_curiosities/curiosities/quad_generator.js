let particles = [];
function setup() {
  createCanvas(windowWidth, windowHeight);
}

function draw()
  {
      background(18,18,18);
      if (mouseIsPressed)
      {
      for (let i = 0; i < 5; i++)
        {
          let p = new Particle();
          particles.push(p);
        }
      }
      for (let i = particles.length - 1; i >= 0; i--)
      {
        particles[i].update();
        particles[i].show();
        if(particles[i].finished())
        {
          particles.splice(i,1);
        }
      }

  }

  class Particle{
    constructor(){
      this.size = 10;
      this.x = mouseX;
      this.y = mouseY;
        this.x2 = mouseX + random(-this.size,this.size);
        this.y2 = mouseY + random(-this.size,this.size);
          this.x3 = mouseX + random(-this.size,this.size);
          this.y3 = mouseY + random(-this.size,this.size);
            this.x4 = mouseX + random(-this.size,this.size);
            this.y4 = mouseY + random(-this.size,this.size);
      this.vx = random(-1,1);
      this.vy = random(-2,-1);
      this.alpha = 255;
      this.size = random(1,25);
      this.colorr = random(0,255);
      this.colorg = random(0,255);
      this.colorb = random(0,255);
    }
    update(){
      this.x += this.vx;
      this.y += this.vy;
        this.x2 += this.vx;
        this.y2 += this.vy;
          this.x3 += this.vx;
          this.y3 += this.vy;
            this.x4 += this.vx;
            this.y4 += this.vy;

      this.colorr += random(-5,5);
      this.colorg += random(-5,5);
      this.colorb += random(-5,5);
      this.alpha-=5;
      this.size += 1;
      if(this.size < 1)
      {
        this.alpha=0;
      }
    }
    finished(){
      return this.alpha < 0;
    }
    show(){
      stroke(0);
      noStroke();
    //  fill(this.colorr,this.colorg,this.colorb,this.alpha);
      fill(this.colorr,0,0,this.alpha);
     //ellipse(this.x,this.y,this.size);
    quad (this.x, this.y, this.x2,this.y2, this.x3,this.y3, this.x4,this.y4);
    }
  }
