let particles = [];
let g = 10;
function setup() {
  frameRate(60);
  createCanvas(600, 500);
}

function draw()
  {
      background(18,18,18);
      for (let i = particles.length - 1; i >= 0; i--)
      {
        particles[i].update();
        particles[i].show();
        if(particles[i].finished())
        {
          particles.splice(i,1);
        }
        /*
        for(let k = particles.length - 1; k>=0; k--)
        {
          if((particles[i].getX()) < (particles[k].getX()) && particles[i] != particles[k] )
          {
              if((particles[i].getX() + 40) > (particles[k].getX()) && particles[i] != particles[k] )
            {
              if((particles[i].getY()) < (particles[k].getX()) && particles[i] != particles[k] )
              {
                  if((particles[i].getY() + 40) > (particles[k].getX()) && particles[i] != particles[k] )
                {
              particles[i].inverseVX();
            particles[i].inverseVY();
            }
        }
         }

            }
        }
        */
      }
  }

  function mouseClicked(){
      let p = new Particle();
      particles.push(p);
  }

  class Particle{
    constructor(){
      this.x = mouseX;
      this.y = mouseY;
      this.mass = 5;

      this.vx = random(-4,4);
      this.vy = 1;
      this.alpha = 255;
      this.size = random(10,20) * 2;
      //this.size = 40;
      this.colorr = random(0,255);
      this.colorg = random(0,255);
      this.colorb = random(0,255);
      this.viscosity = random((0.4),(0.95));
    }
    update(){
      this.alpha -= 1;
      if(this.y > 460)
      {
        this.vy = -(abs(this.vy));
        this.vy = this.vy * this.viscosity;
      }
      if(this.x > 600)
      {
        this.vx = -(abs(this.vx));
      }
      if(this.x < 0)
        {
          this.vx = (abs(this.vx));
        }
        this.x += this.vx;
        this.y += this.vy
        this.vy += (this.mass*g) * (1/60);
    }
    inverseVX(){
      this.vx = -this.vx;
    }
    inverseVY(){
      this.vy = -this.vy;
    }

    randomColor(){
      this.colorr = random(0,255);
        this.colorg = random(0,255);
          this.colorb = random(0,255);
    }

    getX(){
      return this.x;
    }
    getY(){
      return this.y;
    }
    finished(){
      return this.alpha < 0;
    }
    show(){
//      ellipseMode(CORNER);
      stroke(255);
      noStroke();
      fill(this.colorr,this.colorg,this.colorb,this.alpha);
      ellipse(this.x,this.y,this.size);
    }
  }
