function analizo() {
  const text = document.getElementById("text").value.toLowerCase();
  const out = document.getElementById("output");

  let level = "E SIGURT";
  let className = "safe";
  let fill = "20%";

  let why = "Kjo fjali shpreh mendim pa sulm personal.";
  let hurt = "Nuk krijon presion emocional.";
  let better = "Nuk kërkon riformulim.";
  let positive = "Komunikim i shëndetshëm.";

  const soft = [
    {
      phrase: "kjo s'është në rregull",
      why: "Kritikë e përgjithshme pa shpjegim.",
      hurt: "Mund të duket si refuzim personal.",
      better: "“Mendoj se kjo pjesë mund të përmirësohet.”",
      positive: "“Ka potencial dhe vlerë.”"
    },
    {
      phrase: "nuk po e bën mirë",
      why: "Fokus te personi.",
      hurt: "Ul vetëbesimin.",
      better: "“Kjo metodë nuk po funksionon siç pritej.”",
      positive: "“Le ta rregullojmë bashkë.”"
    }
  ];

  const hard = ["je i pavlerë", "s'di asgjë", "je qesharak"];

  hard.forEach(p => {
    if (text.includes(p)) {
      level = "BULLIZUESE";
      className = "danger";
      fill = "90%";
      why = "Gjuhë denigruese dhe sulm personal.";
      hurt = "Shkakton turp dhe përjashtim.";
      better = "Hiq etiketimin personal.";
      positive = "“Le të flasim për zgjidhje.”";
    }
  });

  soft.forEach(o => {
    if (text.includes(o.phrase) && level !== "BULLIZUESE") {
      level = "KRITIKË E ASHPËR";
      className = "warning";
      fill = "55%";
      why = o.why;
      hurt = o.hurt;
      better = o.better;
      positive = o.positive;
    }
  });

  out.innerHTML = `
    <div class="result ${className}">
      <h3>Niveli: ${level}</h3>

      <div class="section"><strong>Pse mund të lëndojë:</strong><p>${why}</p><p>${hurt}</p></div>
      <div class="section"><strong>Riformulim etik:</strong><p>${better}</p></div>
      <div class="section"><strong>Alternativë pozitive:</strong><p>${positive}</p></div>

      <div class="progress">
        <div class="bar" style="--fill:${fill}"></div>
      </div>
    </div>
  `;
}
