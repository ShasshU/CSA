from reportlab.lib.pagesizes import letter
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib.units import inch
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Preformatted, Table, TableStyle, PageBreak
from reportlab.lib import colors
from reportlab.lib.enums import TA_CENTER, TA_LEFT
from datetime import datetime

# Create PDF
pdf_filename = "Arrays_TestCase.pdf"
doc = SimpleDocTemplate(pdf_filename, pagesize=letter,
                        rightMargin=72, leftMargin=72,
                        topMargin=72, bottomMargin=18)

# Container for the 'Flowable' objects
elements = []

# Define styles
styles = getSampleStyleSheet()
styles.add(ParagraphStyle(name='Center', alignment=TA_CENTER))
styles.add(ParagraphStyle(name='Code',
                         fontName='Courier',
                         fontSize=9,
                         leftIndent=20,
                         rightIndent=20,
                         spaceAfter=10))

# Title
title = Paragraph("<b>Arrays.java - Test Case Documentation</b>", styles['Title'])
elements.append(title)
elements.append(Spacer(1, 0.2*inch))

# Student Info
date = Paragraph(f"<b>Date:</b> {datetime.now().strftime('%B %d, %Y')}", styles['Normal'])
elements.append(date)
elements.append(Spacer(1, 0.1*inch))

course = Paragraph("<b>Course:</b> Computer Science A", styles['Normal'])
elements.append(course)
elements.append(Spacer(1, 0.2*inch))

# Test Purpose
purpose_title = Paragraph("<b>1. Test Purpose</b>", styles['Heading2'])
elements.append(purpose_title)
elements.append(Spacer(1, 0.1*inch))

purpose_text = """This test case validates the Arrays.java program, which demonstrates the use of
parallel arrays, array manipulation methods, and the Java Time API. The program stores and displays
climate data for three cities using three parallel arrays."""
purpose = Paragraph(purpose_text, styles['Normal'])
elements.append(purpose)
elements.append(Spacer(1, 0.2*inch))

# Requirements
req_title = Paragraph("<b>2. Program Requirements</b>", styles['Heading2'])
elements.append(req_title)
elements.append(Spacer(1, 0.1*inch))

requirements = [
    ["Requirement", "Status"],
    ["Create String array for city names (Las Vegas, Minsk, Sao Paulo)", "✓ Pass"],
    ["Create int array for average high temps (104°F, 73°F, 80°F)", "✓ Pass"],
    ["Create double array for precipitation (4.17\", 26.7\", 55.0\")", "✓ Pass"],
    ["Maintain parallel array structure with matching indices", "✓ Pass"],
    ["Display table with city climate information", "✓ Pass"],
    ["Implement getLastElement() method", "✓ Pass"],
    ["Implement printArray() method", "✓ Pass"],
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
compile_cmd = Preformatted("$ javac Arrays.java\n(No errors - compilation successful)", styles['Code'])
elements.append(compile_cmd)
elements.append(Spacer(1, 0.1*inch))

run_text = Paragraph("<b>3.2 Runtime Test</b>", styles['Heading3'])
elements.append(run_text)
run_cmd = Preformatted("$ java Arrays", styles['Code'])
elements.append(run_cmd)
elements.append(Spacer(1, 0.2*inch))

# Actual Output
output_title = Paragraph("<b>4. Actual Output</b>", styles['Heading2'])
elements.append(output_title)
elements.append(Spacer(1, 0.1*inch))

actual_output = """Program executed on: February 11, 2026 at 01:29:55 PM

=== City Climate Data ===

Las Vegas has an average annual precipitation of 4.17 inches.
Las Vegas has an average annual high temp of 104 degrees Fahrenheit.
Minsk has an average annual precipitation of 26.7 inches.
Minsk has an average annual high temp of 73 degrees Fahrenheit.
Sao Paulo has an average annual precipitation of 55.0 inches.
Sao Paulo has an average annual high temp of 80 degrees Fahrenheit.

The last element of the String array is: Sao Paulo

=== All Cities in Array ===
Item 1: Las Vegas
Item 2: Minsk
Item 3: Sao Paulo"""

output_pre = Preformatted(actual_output, styles['Code'])
elements.append(output_pre)
elements.append(PageBreak())

# Expected vs Actual
comparison_title = Paragraph("<b>5. Expected vs. Actual Comparison</b>", styles['Heading2'])
elements.append(comparison_title)
elements.append(Spacer(1, 0.1*inch))

comparison_text = """The program output matches all expected requirements:"""
comparison = Paragraph(comparison_text, styles['Normal'])
elements.append(comparison)
elements.append(Spacer(1, 0.1*inch))

comparison_data = [
    ["Feature", "Expected", "Actual", "Match"],
    ["Las Vegas precipitation", "4.17 inches", "4.17 inches", "✓"],
    ["Las Vegas high temp", "104°F", "104°F", "✓"],
    ["Minsk precipitation", "26.7 inches", "26.7 inches", "✓"],
    ["Minsk high temp", "73°F", "73°F", "✓"],
    ["Sao Paulo precipitation", "55.0 inches", "55.0 inches", "✓"],
    ["Sao Paulo high temp", "80°F", "80°F", "✓"],
    ["getLastElement() output", "Sao Paulo", "Sao Paulo", "✓"],
    ["printArray() format", "Item 1, 2, 3...", "Item 1, 2, 3...", "✓"],
    ["Date/Time display", "Current date/time", "Feb 11, 2026 01:29 PM", "✓"]
]

comp_table = Table(comparison_data, colWidths=[1.8*inch, 1.5*inch, 1.5*inch, 0.7*inch])
comp_table.setStyle(TableStyle([
    ('BACKGROUND', (0, 0), (-1, 0), colors.grey),
    ('TEXTCOLOR', (0, 0), (-1, 0), colors.whitesmoke),
    ('ALIGN', (0, 0), (-1, -1), 'LEFT'),
    ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
    ('FONTSIZE', (0, 0), (-1, 0), 9),
    ('BOTTOMPADDING', (0, 0), (-1, 0), 12),
    ('BACKGROUND', (0, 1), (-1, -1), colors.beige),
    ('GRID', (0, 0), (-1, -1), 1, colors.black),
    ('FONTSIZE', (0, 1), (-1, -1), 8),
    ('ALIGN', (3, 1), (3, -1), 'CENTER'),
]))
elements.append(comp_table)
elements.append(Spacer(1, 0.3*inch))

# Method Testing
method_title = Paragraph("<b>6. Method Verification</b>", styles['Heading2'])
elements.append(method_title)
elements.append(Spacer(1, 0.1*inch))

method1 = Paragraph("<b>6.1 getLastElement() Method</b>", styles['Heading3'])
elements.append(method1)
method1_text = """<b>Purpose:</b> Returns the last element of a String array<br/>
<b>Test Input:</b> String array ["Las Vegas", "Minsk", "Sao Paulo"]<br/>
<b>Expected Output:</b> "Sao Paulo"<br/>
<b>Actual Output:</b> "Sao Paulo"<br/>
<b>Status:</b> <font color="green">PASS ✓</font>"""
elements.append(Paragraph(method1_text, styles['Normal']))
elements.append(Spacer(1, 0.15*inch))

method2 = Paragraph("<b>6.2 printArray() Method</b>", styles['Heading3'])
elements.append(method2)
method2_text = """<b>Purpose:</b> Prints all elements in a String array with item numbers<br/>
<b>Test Input:</b> String array ["Las Vegas", "Minsk", "Sao Paulo"]<br/>
<b>Expected Output:</b> "Item 1: Las Vegas", "Item 2: Minsk", "Item 3: Sao Paulo"<br/>
<b>Actual Output:</b> Matches expected format<br/>
<b>Status:</b> <font color="green">PASS ✓</font>"""
elements.append(Paragraph(method2_text, styles['Normal']))
elements.append(Spacer(1, 0.3*inch))

# Code Quality
quality_title = Paragraph("<b>7. Code Quality Assessment</b>", styles['Heading2'])
elements.append(quality_title)
elements.append(Spacer(1, 0.1*inch))

quality_data = [
    ["Criterion", "Assessment"],
    ["Comments present and descriptive", "✓ Excellent"],
    ["Proper method documentation (Javadoc)", "✓ Excellent"],
    ["Parallel arrays properly aligned", "✓ Excellent"],
    ["Java Time API correctly implemented", "✓ Excellent"],
    ["Code formatting and readability", "✓ Excellent"],
    ["Error handling (null checks)", "✓ Good"],
    ["Variable naming conventions", "✓ Excellent"]
]

quality_table = Table(quality_data, colWidths=[3.5*inch, 2.5*inch])
quality_table.setStyle(TableStyle([
    ('BACKGROUND', (0, 0), (-1, 0), colors.grey),
    ('TEXTCOLOR', (0, 0), (-1, 0), colors.whitesmoke),
    ('ALIGN', (0, 0), (-1, -1), 'LEFT'),
    ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
    ('FONTSIZE', (0, 0), (-1, 0), 10),
    ('BOTTOMPADDING', (0, 0), (-1, 0), 12),
    ('BACKGROUND', (0, 1), (-1, -1), colors.beige),
    ('GRID', (0, 0), (-1, -1), 1, colors.black),
    ('FONTSIZE', (0, 1), (-1, -1), 9),
]))
elements.append(quality_table)
elements.append(Spacer(1, 0.3*inch))

# Conclusion
conclusion_title = Paragraph("<b>8. Test Conclusion</b>", styles['Heading2'])
elements.append(conclusion_title)
elements.append(Spacer(1, 0.1*inch))

conclusion_text = """<b>Overall Result: <font color="green">PASS ✓</font></b><br/><br/>
The Arrays.java program successfully meets all specified requirements. The program correctly:
<br/>• Creates and maintains three parallel arrays for city data
<br/>• Displays formatted output matching the expected format
<br/>• Implements both required static methods (getLastElement and printArray)
<br/>• Utilizes the Java Time API to display current date and time
<br/>• Includes comprehensive comments and documentation
<br/><br/>
All test cases passed without errors. The program is ready for submission."""

conclusion = Paragraph(conclusion_text, styles['Normal'])
elements.append(conclusion)

# Build PDF
doc.build(elements)
print(f"Test case documentation created: {pdf_filename}")
