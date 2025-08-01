# Polynomial Interpolation Results

## Test Case 1
- **Input**: testcase1.json
- **n**: 4, **k**: 3 (degree = 2)
- **Points used**:
  - Point 1: x = 1, y = 4 (decoded from base 10: 4)
  - Point 2: x = 2, y = 7 (decoded from base 2: 111)
  - Point 3: x = 3, y = 12 (decoded from base 10: 12)
- **Terms**:
  - Term 1: 12
  - Term 2: -21
  - Term 3: 12
- **Constant term (secret C)**: **3**

## Test Case 2
- **Input**: testcase2.json
- **n**: 10, **k**: 7 (degree = 6)
- **Points used**:
  - Point 1: x = 1, y = 995085094601491 (decoded from base 6: 13444211440455345511)
  - Point 2: x = 2, y = 21394886326566393 (decoded from base 15: aed7015a346d63)
  - Point 3: x = 3, y = 196563650089608567 (decoded from base 15: 6aeeb69631c227c)
  - Point 4: x = 4, y = 1016509518118225951 (decoded from base 16: e1b5e05623d881f)
  - Point 5: x = 5, y = 3711974121218449851 (decoded from base 8: 316034514573652620673)
  - Point 6: x = 6, y = 10788619898233492461 (decoded from base 3: 2122212201122002221120200210011020220200)
  - Point 7: x = 7, y = 26709394976508342463 (decoded from base 3: 20120221122211000100210021102001201112121)
- **Terms**:
  - Term 1: 6965595662210437
  - Term 2: -449292612857894253
  - Term 3: 6879727753136299845
  - Term 4: -35577833134137908285
  - Term 5: 77951456545587446871
  - Term 6: -75520339287634447227
  - Term 7: 26709394976508342463
- **Constant term (secret C)**: **79836264049851**

## Summary
- **Test Case 1 Answer**: 3
- **Test Case 2 Answer**: 79836264049851

## Files
- `CatalogPolynomialSolver.java` - Main Java solution
- `testcase1.json` - First test case
- `testcase2.json` - Second test case
- `json-simple-1.1.1.jar` - JSON library
- `run.bat` - Batch file to run with increased memory
- `README.md` - Documentation
- `package.json` - Project configuration

## How to Run
```bash
# Compile
javac -cp "json-simple-1.1.1.jar" CatalogPolynomialSolver.java

# Run with increased memory
java -Xmx2g -cp ".;json-simple-1.1.1.jar" CatalogPolynomialSolver

# Or use the batch file
run.bat
``` 