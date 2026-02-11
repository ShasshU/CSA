from reportlab.lib.pagesizes import letter
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib.units import inch
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Preformatted, Table, TableStyle, PageBreak
from reportlab.lib import colors
from reportlab.lib.enums import TA_CENTER
from datetime import datetime

# Create PDF
pdf_filename = "TraversingArray_TestCase.pdf"
doc = SimpleDocTemplate(pdf_filename, pagesize=letter,
                        rightMargin=72, leftMargin=72,
                        topMargin=72, bottomMargin=18)

elements = []
styles = getSampleStyleSheet()
styles.add(ParagraphStyle(name='Center', alignment=TA_CENTER))
styles.add(ParagraphStyle(name='Code',
                         fontName='Courier',
                         fontSize=9,
                         leftIndent=20,
                         rightIndent=20,
                         spaceAfter=10))

# Title
title = Paragraph("<b>TraversingArray.java - Test Case Documentation</b>", styles['Title'])
elements.append(title)
elements.append(Spacer(1, 0.2*inch))

# Info
date = Paragraph(f"<b>Date:</b> {datetime.now().strftime('%B %d, %Y')}", styles['Normal'])
elements.append(date)
elements.append(Spacer(1, 0.1*inch))
course = Paragraph("<b>Course:</b> Computer Science A", styles['Normal'])
elements.append(course)
elements.append(Spacer(1, 0.2*inch))

# Purpose
purpose_title = Paragraph("<b>1. Test Purpose</b>", styles['Heading2'])
elements.append(purpose_title)
elements.append(Spacer(1, 0.1*inch))
purpose_text = """This test case validates the TraversingArray.java program, which demonstrates array traversal
techniques including forward iteration, reverse iteration, searching, calculating averages, and modifying array elements."""
purpose = Paragraph(purpose_text, styles['Normal'])
elements.append(purpose)
elements.append(Spacer(1, 0.2*inch))

# Requirements
req_title = Paragraph("<b>2. Program Requirements</b>", styles['Heading2'])
elements.append(req_title)
elements.append(Spacer(1, 0.1*inch))

requirements = [
    ["Requirement", "Status"],
    ["Create printNeatly() method to display array with proper formatting", "✓ Pass"],
    ["Create reverseNeatly() method to display array in reverse", "✓ Pass"],
    ["Create countZero() method to find and count zero values", "✓ Pass"],
    ["Create getAverage() method returning average to 2 decimal places", "✓ Pass"],
    ["Create switchFirstSecond() method to swap first two elements", "✓ Pass"],
    ["Use Java Time API to display date/time", "✓ Pass"],
    ["Include appropriate comments", "✓ Pass"]
]

req_table = Table(requirements, colWidths=[4.5*inch, 1.5*inch])
req_table.setStyle(TableStyle([
    ('BACKGROUND', (0, 0), (-1, 0), colors.grey),
    ('TEXTCOLOR', (0, 0), (-1, 0), colors.whitesmoke),
    ('ALIGN', (0, 0), (-1, -1), 'LEFT'),
    ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
    ('FONTSIZE', (0, 0), (-1, 0), 10),
    ('BOTTOMPADDING', (0, 0), (-1, 0), 12),
    ('BACKGROUND', (0, 1), (-1, -1), colors.beige),
    ('GRID', (0, 0), (-1, -1), 1, colors.black),
    ('FONTSIZE', (0, 1), (-1, -1), 9),
    ('ALIGN', (1, 1), (1, -1), 'CENTER'),
]))
elements.append(req_table)
elements.append(Spacer(1, 0.3*inch))

# Test Execution
exec_title = Paragraph("<b>3. Test Execution</b>", styles['Heading2'])
elements.append(exec_title)
elements.append(Spacer(1, 0.1*inch))

compile_text = Paragraph("<b>3.1 Compilation Test</b>", styles['Heading3'])
elements.append(compile_text)
compile_cmd = Preformatted("$ javac TraversingArray.java\n(No errors - compilation successful)", styles['Code'])
elements.append(compile_cmd)
elements.append(Spacer(1, 0.1*inch))

run_text = Paragraph("<b>3.2 Runtime Test</b>", styles['Heading3'])
elements.append(run_text)
run_cmd = Preformatted("$ java TraversingArray", styles['Code'])
elements.append(run_cmd)
elements.append(Spacer(1, 0.2*inch))

# Actual Output
output_title = Paragraph("<b>4. Actual Output</b>", styles['Heading2'])
elements.append(output_title)
elements.append(Spacer(1, 0.1*inch))

actual_output = """Program executed on: February 11, 2026 at 01:48:57 PM

The goals scored were 1, 2, 0, 3, 2, 4, 2, 1, 0, 2, 0, 1, 3, and 2.

The goals scored backwards are 2, 3, 1, 0, 2, 0, 1, 2, 4, 2, 3, 0, 2, and 1.

We scored 0 goals in game 3
We scored 0 goals in game 9
We scored 0 goals in game 11
We had 3 games, where we did not score a goal.

The average number of goals score per game is 1.64

The actual goals were 2, 1, 0, 3, 2, 4, 2, 1, 0, 2, 0, 1, 3, and 2."""

output_pre = Preformatted(actual_output, styles['Code'])
elements.append(output_pre)
elements.append(Spacer(1, 0.3*inch))

# Method Testing
method_title = Paragraph("<b>5. Method Verification</b>", styles['Heading2'])
elements.append(method_title)
elements.append(Spacer(1, 0.1*inch))

method1 = Paragraph("<b>5.1 printNeatly() Method</b>", styles['Heading3'])
elements.append(method1)
method1_text = """<b>Purpose:</b> Prints array with commas between elements and "and" before last element<br/>
<b>Expected:</b> "1, 2, 0, 3, 2, 4, 2, 1, 0, 2, 0, 1, 3, and 2."<br/>
<b>Actual:</b> Matches expected format<br/>
<b>Status:</b> <font color="green">PASS ✓</font>"""
elements.append(Paragraph(method1_text, styles['Normal']))
elements.append(Spacer(1, 0.15*inch))

method2 = Paragraph("<b>5.2 reverseNeatly() Method</b>", styles['Heading3'])
elements.append(method2)
method2_text = """<b>Purpose:</b> Prints array in reverse order with proper formatting<br/>
<b>Expected:</b> "2, 3, 1, 0, 2, 0, 1, 2, 4, 2, 3, 0, 2, and 1."<br/>
<b>Actual:</b> Matches expected format<br/>
<b>Status:</b> <font color="green">PASS ✓</font>"""
elements.append(Paragraph(method2_text, styles['Normal']))
elements.append(Spacer(1, 0.15*inch))

method3 = Paragraph("<b>5.3 countZero() Method</b>", styles['Heading3'])
elements.append(method3)
method3_text = """<b>Purpose:</b> Counts and displays games with zero goals<br/>
<b>Expected:</b> 3 games (game 3, 9, and 11)<br/>
<b>Actual:</b> Correctly identified all 3 games with 0 goals<br/>
<b>Status:</b> <font color="green">PASS ✓</font>"""
elements.append(Paragraph(method3_text, styles['Normal']))
elements.append(Spacer(1, 0.15*inch))

method4 = Paragraph("<b>5.4 getAverage() Method</b>", styles['Heading3'])
elements.append(method4)
method4_text = """<b>Purpose:</b> Calculates average goals per game to 2 decimal places<br/>
<b>Calculation:</b> (1+2+0+3+2+4+2+1+0+2+0+1+3+2) / 14 = 1.642857... ≈ 1.64<br/>
<b>Expected:</b> 1.64<br/>
<b>Actual:</b> 1.64<br/>
<b>Status:</b> <font color="green">PASS ✓</font>"""
elements.append(Paragraph(method4_text, styles['Normal']))
elements.append(Spacer(1, 0.15*inch))

method5 = Paragraph("<b>5.5 switchFirstSecond() Method</b>", styles['Heading3'])
elements.append(method5)
method5_text = """<b>Purpose:</b> Swaps first and second array elements<br/>
<b>Before:</b> [1, 2, 0, 3, ...]<br/>
<b>After:</b> [2, 1, 0, 3, ...]<br/>
<b>Actual:</b> "2, 1, 0, 3, 2, 4, 2, 1, 0, 2, 0, 1, 3, and 2."<br/>
<b>Status:</b> <font color="green">PASS ✓</font>"""
elements.append(Paragraph(method5_text, styles['Normal']))
elements.append(Spacer(1, 0.3*inch))

# Conclusion
conclusion_title = Paragraph("<b>6. Test Conclusion</b>", styles['Heading2'])
elements.append(conclusion_title)
elements.append(Spacer(1, 0.1*inch))

conclusion_text = """<b>Overall Result: <font color="green">PASS ✓</font></b><br/><br/>
The TraversingArray.java program successfully meets all specified requirements. All five methods work correctly:
<br/>• printNeatly() formats array output with proper punctuation
<br/>• reverseNeatly() displays array in reverse with correct formatting
<br/>• countZero() accurately identifies and counts zero values
<br/>• getAverage() calculates and rounds average correctly to 2 decimal places
<br/>• switchFirstSecond() properly swaps the first two array elements
<br/><br/>
The program uses Java Time API and includes appropriate comments. All test cases passed. Ready for submission."""

conclusion = Paragraph(conclusion_text, styles['Normal'])
elements.append(conclusion)

# Build PDF
doc.build(elements)
print(f"Test case documentation created: {pdf_filename}")
